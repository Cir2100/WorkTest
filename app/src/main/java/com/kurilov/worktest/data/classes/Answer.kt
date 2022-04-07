package com.kurilov.worktest.data.classes

data class Answer(
    val status : String,
    val totalResults : Int,
    val articles : List<Article>
)
