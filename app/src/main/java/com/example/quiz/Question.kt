package com.example.quiz

data class Question(
    val question: String,
    val options: Array<String>,
    val answers: IntArray
)