package com.codingbhasha.assingment

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingbhasha.assingment.adapters.recyclerview.LatestMoviesAdpater
import com.codingbhasha.assingment.base.BaseActivity
import com.codingbhasha.assingment.databinding.ActivityMainBinding
import com.codingbhasha.assingment.repo.Responce
import com.codingbhasha.assingment.util.App
import com.codingbhasha.assingment.viewmodels.MoviesViewModel
import com.codingbhasha.assingment.viewmodels.MoviesViewModelFactory


class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var moviesView: MoviesViewModel
    private var adapter: LatestMoviesAdpater? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repo = (application as App).repos
        moviesView =
            ViewModelProvider(this, MoviesViewModelFactory(repo)).get(MoviesViewModel::class.java)
        moviesView.movie.observe(this, {

            when (it) {
                is Responce.Loading-> {}
                is Responce.Success -> {
                    it.data?.let { it1 -> adapter!!.setList(it1) }
                }
                is Responce.Error -> {
                    it.error?.let { ita-> Toast.makeText(this,ita, Toast.LENGTH_LONG).show() }
                }
            }


        })


    }

    override val layoutResId: Int
        get() = R.layout.activity_main
}