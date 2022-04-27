package com.codingbhasha.assingment.adapters.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.codingbhasha.assingment.R
import com.codingbhasha.assingment.databinding.MovieBinding
import com.codingbhasha.assingment.models.MovieModel
import com.codingbhasha.assingment.util.Utils


class LatestMoviesAdpater(private var ctx: Context) : RecyclerView.Adapter<ViewHolder>() {
   private var list: List<MovieModel> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: MovieBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movie,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = list.get(position)
        if (movie.poster_path.toString()=="null"){

            holder.binding.poster.setImageDrawable(ctx.getDrawable(R.drawable.not))
        }else{
            Glide.with(ctx.applicationContext)
                .load(Utils.PicapiURL+movie.poster_path)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(holder.binding.poster)
        }
        holder.binding.movieModel = movie
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    @JvmName("setList1")
    fun setList(list: List<MovieModel>) {
        this.list = list
        notifyDataSetChanged()
    }


}

class ViewHolder(var binding: MovieBinding) : RecyclerView.ViewHolder(
    binding.root
)