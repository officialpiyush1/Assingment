package com.codingbhasha.assingment.retrofit

import com.codingbhasha.assingment.models.MovieModel
import com.codingbhasha.assingment.models.TopRated
import com.codingbhasha.assingment.util.Utils
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("top_rated")
    suspend fun latest(@Query("api_key") api: String = "3c14273e897ce333706a39188f41a038"): Response<TopRated>

    companion object {
        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Utils.apiURL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }

}