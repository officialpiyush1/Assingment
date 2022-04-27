package com.codingbhasha.assingment.util

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi


class Utils {

    companion object {

        val PicapiURL ="https://image.tmdb.org/t/p/original/"
        var apiURL =  "https://api.themoviedb.org/3/movie/"

        @RequiresApi(Build.VERSION_CODES.M)
        fun isOnline(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                return true
            }
            return false
        }

    }

}