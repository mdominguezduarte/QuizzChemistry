package com.example.quizchemistry

data class Question (
    val id : Int,
    val question: String,
    val image : Int,
    val optOne : String,
    val optTwo : String,
    val optThree : String,
    val optFour : String,
    val correct : Int
    )

