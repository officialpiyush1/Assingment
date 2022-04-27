package com.codingbhasha.assingment.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingbhasha.assingment.repo.Repo



class MoviesViewModelFactory(private val Repo: Repo): ViewModelProvider.Factory {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviesViewModel(Repo) as T
    }
}
