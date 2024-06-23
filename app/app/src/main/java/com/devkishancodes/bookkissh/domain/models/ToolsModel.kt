package com.devkishancodes.bookkissh.domain.models

import androidx.annotation.DrawableRes
import com.devkishancodes.bookkissh.domain.enums.ToolsType

data class ToolsModel(
    val title: String,
    @DrawableRes
    val image: Int,
    val type: ToolsType
)