package com.codingbhasha.assingment.sqllite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.codingbhasha.assingment.conveter.Conveter
import com.codingbhasha.assingment.models.MovieModel


@TypeConverters( Conveter::class)
@Database(entities = [MovieModel::class], version = 1, exportSchema = false)
abstract class SqlLite : RoomDatabase() {

    abstract fun mDao():DAO
    companion object{
        @Volatile
        private var INSTANCE: SqlLite? = null

        fun getDatabase(context: Context): SqlLite {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        SqlLite::class.java,
                        "movies_db")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }


}