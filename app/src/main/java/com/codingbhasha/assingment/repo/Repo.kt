package com.codingbhasha.assingment.repo

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codingbhasha.assingment.models.MovieModel
import com.codingbhasha.assingment.retrofit.ApiInterface
import com.codingbhasha.assingment.sqllite.SqlLite
import com.codingbhasha.assingment.util.Utils
import org.json.JSONObject
import java.lang.Exception


class Repo(
    private val api: ApiInterface,
    private val movieDatabase: SqlLite,
    val applicationContext: Context
) {
    private val movieLiveData = MutableLiveData<Responce<List<MovieModel>>>()
    val movie: LiveData<Responce<List<MovieModel>>>
        get() = movieLiveData


    @RequiresApi(Build.VERSION_CODES.M)
    suspend fun getMovie() {
        if (Utils.isOnline(applicationContext)) {

            try {
                val result = api.latest()

                if (result.body() != null) {
                    val movi: List<MovieModel> = result.body()!!.results
                    movieDatabase.mDao().insert(movi)
                    movieLiveData.postValue(Responce.Success(result.body()!!.results))
                } else{
                    val  msg = JSONObject( result.errorBody()!!.string())
                    movieLiveData.postValue(Responce.Error(msg.getString("status_message")))
                }

            } catch (e: Exception) {
                movieLiveData.postValue(Responce.Error(e.message.toString()))
            }

        } else {

            try {
                val moviesList = movieDatabase.mDao().getAll()
                movieLiveData.postValue(Responce.Success(moviesList))
            } catch (e: Exception) {
                movieLiveData.postValue(Responce.Error(e.message.toString()))
            }
        }


    }
}