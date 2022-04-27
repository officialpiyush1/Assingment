package com.codingbhasha.assingment.models

data class TopRated(
    val page: Int,
    val results: List<MovieModel>,
    val total_pages: Int,
    val total_results: Int
)