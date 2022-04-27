package com.codingbhasha.assingment.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingbhasha.assingment.models.MovieModel
import com.codingbhasha.assingment.repo.Repo
import com.codingbhasha.assingment.repo.Responce

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.M)
class MoviesViewModel(val Repo: Repo): ViewModel() {
    init {
        viewModelScope.launch (Dispatchers.IO){
            Repo.getMovie()
        }
    }

    lateinit var  movie : LiveData<Responce<List<MovieModel>>>

}