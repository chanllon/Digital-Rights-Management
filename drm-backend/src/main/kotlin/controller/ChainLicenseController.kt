package moe._47saikyo.controller

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.routing.*
import moe._47saikyo.configuration.security.authenticateRequired
import org.koin.ktor.ext.inject
import moe._47saikyo.constant.Constant
import moe._47saikyo.models.HttpStatus
import moe._47saikyo.models.httpRespond
import moe._47saikyo.service.LicenseService
import moe._47saikyo.service.RightService
import moe._47saikyo.service.WalletService

/**
 * License Contract Controller
 *
 * @author 刘一邦
 */
fun Application.chainLicenseController() {
    val licenseService: LicenseService by inject()
    val rightService: RightService by inject()
    val walletService: WalletService by inject()

    routing {
        route("/chain/license") {
            authenticateRequired(Constant.Authentication.NEED_LOGIN) {
                get {
                    val addr = call.parameters["addr"]
                    val caller = call.parameters["caller"]


                    when {
                        //addr为空
                        (addr == null) -> {
                            call.httpRespond(HttpStatus.BAD_REQUEST with "无效的地址")
                            return@get
                        }

                        //caller为空
                        (caller == null) -> {
                            call.httpRespond(HttpStatus.BAD_REQUEST with "无效的调用者")
                            return@get
                        }
                    }

                    val rights = licenseService.getPureData(caller!!, addr!!)

                    call.httpRespond(data = mapOf(Constant.RespondField.LICENSE to rights))
                }

                //获取指定钱包所部署的版权合约列表
                get("/by-deployer") {
                    val addr = call.parameters["addr"]

                    when {
                        //addr为空
                        (addr == null) -> {
                            call.httpRespond(HttpStatus.BAD_REQUEST with "无效的地址")
                            return@get
                        }
                    }

                    val licenses = licenseService.getLicenses(addr!!)

                    call.httpRespond(data = mapOf(Constant.RespondField.LICENSE to licenses))
                }

                get("/by-right") {
                    val addr = call.parameters["addr"]
                    val loginId =
                        call.principal<JWTPrincipal>()?.payload?.getClaim(Constant.Authentication.USER_ID_CLAIM)
                            ?.asLong()
                    val loginAddr = loginId?.let { id -> walletService.getWallet(id)?.address }

                    when {
                        //addr为空
                        (addr == null) -> {
                            call.httpRespond(HttpStatus.BAD_REQUEST with "无效的地址")
                            return@get
                        }
                    }

                    val right = rightService.getPureData(loginAddr!!, addr!!)
                    val licenses = right.licenses
//                        .map { licenseService.getPureData(loginAddr, it) }
                        .filter { it.deployer == loginAddr || right.deployer == loginAddr }

                    call.httpRespond(data = mapOf(Constant.RespondField.LICENSE to licenses))
                }
            }
        }
    }
}