package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Group(
    val color: String,
    val hex: String,
    val properties: List<Property>
)