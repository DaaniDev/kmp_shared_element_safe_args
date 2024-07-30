package model

import org.jetbrains.compose.resources.DrawableResource

data class ImageModel(
    val id: Int,
    val drawableResource: DrawableResource,
    val name: String,
    val description: String
)
