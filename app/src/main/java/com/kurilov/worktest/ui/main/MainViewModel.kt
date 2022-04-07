package com.kurilov.worktest.ui.main

import androidx.lifecycle.ViewModel
import com.kurilov.worktest.data.repositories.ApiRepo

class MainViewModel : ViewModel() {

    private val apiRepo = ApiRepo

    fun getNews() = apiRepo.getNews()

}