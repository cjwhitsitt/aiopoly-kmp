package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestBody(
    val data: RequestData
) {
    @Serializable
    data class RequestData(
        val theme: String
    )

    companion object {
        fun create(theme: String) = RequestBody(
            data = RequestData(
                theme = theme
            )
        )
    }
}
