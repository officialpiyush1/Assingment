package com.codingbhasha.assingment.util

import android.app.Application
import com.codingbhasha.assingment.repo.Repo
import com.codingbhasha.assingment.retrofit.ApiInterface
import com.codingbhasha.assingment.sqllite.SqlLite

class App: Application() {
    lateinit var repos: Repo
    override fun onCreate() {
        super.onCreate()
        inti()
    }

    private fun inti() {
        val api =  ApiInterface.create()
        val movieDatabase =  SqlLite.getDatabase(applicationContext)
        repos =  Repo(api,movieDatabase,applicationContext)
    }
}