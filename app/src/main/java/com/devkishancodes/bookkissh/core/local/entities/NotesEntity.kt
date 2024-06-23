package com.devkishancodes.bookkissh.core.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val bookId: String,
    val note: String
)