package com.devkishancodes.bookkissh.presentation.viewmodel.viewmodel

import androidx.lifecycle.ViewModel
import com.devkishancodes.bookkissh.domain.repo.MainRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repo: MainRepo) : ViewModel() {
    val homeLiveData get() = repo.homeLiveData

    fun getHomeData() {
        CoroutineScope(Dispatchers.IO).launch {
            repo.getHomeData()
        }
    }


}