package moe._47saikyo.models

data class RightData(
    val addr:String = "",
    val title: String = "",
    val owner: String = "",
    val registrationNumber: String = "",
    val issueTime: Long = 0,
    val expireTime: Long = 0,
    val description: String = "",
    val licenses: List<String> = emptyList(),
)