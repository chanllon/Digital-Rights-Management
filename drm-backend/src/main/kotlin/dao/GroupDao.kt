package moe._47saikyo.dao

import domain.Group
import org.jetbrains.exposed.sql.Op
import org.jetbrains.exposed.sql.SqlExpressionBuilder

/**
 * GroupDao接口
 *
 * @author 刘一邦
 * @since 2024/03/07
 */
interface GroupDao {
    suspend fun getGroup(where: SqlExpressionBuilder.() -> Op<Boolean>): Group?
    suspend fun getAllGroups(): List<Group>
    suspend fun insertGroup(group: Group): Group?
    suspend fun updateGroup(group: Group): Boolean
    suspend fun deleteGroup(group: Group): Boolean
}