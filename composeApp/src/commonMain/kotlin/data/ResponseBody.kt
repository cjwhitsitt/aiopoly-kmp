package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBody(
    val result: ResponseResult
) {
    @Serializable
    data class ResponseResult(
        val groups: List<Group>
    )
}
