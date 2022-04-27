package com.codingbhasha.assingment.sqllite



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codingbhasha.assingment.models.MovieModel

@Dao
interface DAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: List<MovieModel>)


    @Query("SELECT * FROM movie_table")
    suspend fun getAll(): List<MovieModel>
}