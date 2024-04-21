package moe._47saikyo.models

import java.math.BigInteger

data class LicenseDeployForm(
    val rightTitle: String,
    val rightAddr: String,
    val owner: String,
    val issueTime: BigInteger,
    val expireTime: BigInteger,
    val description: String,
)