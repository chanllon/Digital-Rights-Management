package moe._47saikyo.service.impl

import domain.Group
import domain.User
import moe._47saikyo.configuration.security.PasswordEncoder
import moe._47saikyo.dao.GroupDao
import moe._47saikyo.dao.UserDao
import moe._47saikyo.models.GroupTable
import moe._47saikyo.models.UserTable
import moe._47saikyo.service.UserService
import org.koin.java.KoinJavaComponent.inject

/**
 * UserService实现
 *
 * @author 刘一邦
 * @since 2024/01/20
 */
class UserServiceImpl : UserService {
    private val userDao: UserDao by inject(UserDao::class.java)
    private val groupDao: GroupDao by inject(GroupDao::class.java)
    private val passwordEncoder: PasswordEncoder by inject(PasswordEncoder::class.java)

    override suspend fun getDebugUser(): User =
        userDao.getUser { UserTable.username eq "DebugUser" } ?: error("找不到用户")

    override suspend fun getUser(id: Long): User? =
        userDao.getUser { UserTable.id eq id }

    override suspend fun getUser(username: String): User? =
        userDao.getUser { UserTable.username eq username }

    override suspend fun getUserGroup(userid: Long): Group? {
        val user = getUser(userid)
        return if (user == null) null else groupDao.getGroup { GroupTable.id eq user.permissionId }
    }

    override suspend fun insertUser(user: User): User? =
        userDao.insertUser(user)

    override suspend fun updateUser(user: User): Boolean =
        userDao.updateUser(user)
}