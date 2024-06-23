package com.devkishancodes.bookkissh.domain.models

import java.io.Serializable

data class BooksModel(
    val image: String = "",
    val title: String = "",
    val description: String = "",
    val author: String = "",
    val bookPDF: String = "",
):Serializable