package com.kurilov.worktest.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kurilov.worktest.data.api.RetrofitBuilder

object ApiRepo {

    private val apiService = RetrofitBuilder.apiService

    //private val _news = MutableLiveData<MyResult<List<Country>>>()
    //val news : LiveData<MyResult<List<Country>>>
    //    get() = _news
}