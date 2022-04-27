package com.codingbhasha.assingment.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "movie_table" , indices = [Index(value = ["id"], unique = true)])
data class MovieModel(
    @field: PrimaryKey(autoGenerate = true)var rowid: Int,
    val adult: Boolean?,
    val backdrop_path: String?,
    val genre_ids: List<Any>?,
    val id: Int,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Int?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Int?,
    val vote_count: Int?
)
