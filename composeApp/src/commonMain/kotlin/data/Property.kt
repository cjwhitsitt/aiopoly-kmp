package data

import kotlinx.serialization.Serializable

@Serializable
data class Property(
    val name: String,
    val rent: Int
)