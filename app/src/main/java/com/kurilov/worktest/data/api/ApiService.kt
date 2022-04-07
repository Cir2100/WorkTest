package com.kurilov.worktest.data.api

import com.kurilov.worktest.data.classes.Answer
import com.kurilov.worktest.data.classes.Article
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers( "X-Api-Key: 815100e4d94744378a1548bd784eafa0")
    @GET("top-headlines")
    fun getNews(@Query("country") country: String) : Call<Answer>
}