package moe._47saikyo.constant

/**
 * Http自定义状态码，建议使用伴生对象内的预设内容
 *
 * @param code 状态码
 * @param msg 状态信息
 * @author 刘一邦
 */
class HttpStatus(val code: Int = 200, val msg: String = "Success") {
    class Code {
        companion object {
            //成功
            const val SUCCESS = 200

            //参数错误
            const val BAD_REQUEST = 400

            //未登录
            const val UNAUTHORIZED = 401

            //登陆令牌无效
            const val INVALID_TOKEN = 402

            //权限不足
            const val FORBIDDEN = 403

            //资源不存在
            const val NOT_FOUND = 404

            //服务器错误
            const val SERVER_ERROR = 500
        }
    }

    companion object {
        //成功
        val SUCCESS = HttpStatus(Code.SUCCESS, "Success")

        //参数错误
        val BAD_REQUEST = HttpStatus(Code.BAD_REQUEST, "Invalid Argument")

        //登陆令牌无效
        val INVALID_TOKEN = HttpStatus(Code.INVALID_TOKEN, "Invalid Token")

        //未登录
        val UNAUTHORIZED = HttpStatus(Code.UNAUTHORIZED, "Unauthorized")

        //权限不足
        val FORBIDDEN = HttpStatus(Code.FORBIDDEN, "Forbidden")

        //资源不存在
        val NOT_FOUND = HttpStatus(Code.NOT_FOUND, "Not Found")

        //服务器错误
        val SERVER_ERROR = HttpStatus(Code.SERVER_ERROR, "Server Error")
    }
}