
package com.example.imdbclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdbclone.R
import com.example.imdbclone.data.Result

class MovieAdapter(private val list: List<Result>?): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val current = list?.get(position)
        holder.title.text = current?.title ?: ""
        holder.description.text = current?.overview ?: ""
        holder.rating.text = current?.popularity?.toString() ?: ""



        // Load image from drawable using Glide
        Glide.with(holder.itemView.context)
            .load(R.drawable.movie)
            .into(holder.imageView)
    }

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.title1)
        val description = itemView.findViewById<TextView>(R.id.description)
        val rating = itemView.findViewById<TextView>(R.id.rating)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView7)
    }
}
