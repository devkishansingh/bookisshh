package com.devkishancodes.bookkissh.presentation.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.devkishancodes.bookkissh.PdfActivity
import com.devkishancodes.bookkissh.core.local.AppDatabase
import com.devkishancodes.bookkissh.core.local.entities.BookmarksEntity
import com.devkishancodes.bookkissh.core.local.entities.NotesEntity

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("ALL")
class ToolsViewModel(val pdfActivity: PdfActivity) : ViewModel() {

    private var nightMode = false
    val database = AppDatabase.getDatabase(pdfActivity)

    fun toggleNightMode() {
        nightMode = !nightMode
        pdfActivity.binding.pdfView.setNightMode(nightMode)

    }

    fun jumpToPage(pageNo: Int) {
        pdfActivity.binding.pdfView.jumpTo(pageNo, true)
    }

    fun addBookmark() {
        CoroutineScope(Dispatchers.IO).launch {
            val entity =
                BookmarksEntity(0, pdfActivity.bookId, pdfActivity.binding.pdfView.currentPage)
            database?.bookmarksDao()?.addBookmark(entity)
        }
    }

    fun addNote(note: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val entity = NotesEntity(0, pdfActivity.bookId, note)
            database?.notesDao()?.addNote(entity)

        }
    }


}



















