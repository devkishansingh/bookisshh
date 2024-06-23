package com.devkishancodes.bookkissh.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devkishancodes.bookkissh.domain.repo.BookRepo


class BookViewModelFactory (private val repo: BookRepo):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookViewModel(repo) as T
    }
}