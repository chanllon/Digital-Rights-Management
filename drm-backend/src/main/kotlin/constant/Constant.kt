package moe._47saikyo.constant

/**
 * 常量类
 *
 * @author 刘一邦
 * @since 2024/01/20
 */
object Constant {
    object Authentication {
        const val TOKEN_STORAGE = "token"
        const val USER_ID_CLAIM = "user_id"
        const val GROUP_ID_CLAIM = "group_id"
        const val EXPIRE_TIME_CLAIM = "expire_time"

        const val DEFAULT_GROUP_ID = 0L
        const val DEFAULT_EXPIRE_TIME = 3600000L
        const val REMEMBER_ME_EXPIRE_TIME = DEFAULT_EXPIRE_TIME * 24

        const val NEED_LOGIN = "need_login"
        const val PERMISSION_CREATE_CHAIN_ACCOUNT = "permission_create_chain_account"
    }

    object RespondField{
        const val USER = "user"
        const val GROUP = "group"
        const val SELF_PROFILE = "self"
        const val SUCCESS = "success"
        const val ADDRESS = "address"
    }

    object PropertyUrl {
        const val DATASOURCE_DRIVER = "exposed.datasource.driverClassName"
        const val DATASOURCE_URL = "exposed.datasource.jdbcUrl"
        const val DATASOURCE_USERNAME = "exposed.datasource.username"
        const val DATASOURCE_PASSWORD = "exposed.datasource.password"

        const val JWT_SECRET = "JWT.secret"
        const val JWT_ISSUER = "JWT.issuer"
        const val JWT_AUDIENCE = "JWT.audience"
        const val JWT_SUBJECT = "JWT.subject"

        const val CHAIN_SOCKET = "chain.socket"
        const val CHAIN_PASSWORD = "chain.password"
        const val CHAIN_WALLET_FILE = "chain.walletFile"
        const val CHAIN_ID = "chain.chainId"
    }
}