package com.kurilov.worktest.data.api

import com.kurilov.worktest.data.classes.News
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/top-headlines")
    fun getNews() : Call<News>
}