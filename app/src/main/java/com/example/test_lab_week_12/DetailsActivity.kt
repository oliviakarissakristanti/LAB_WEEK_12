package com.example.test_lab_week_12

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.test_lab_week_12.model.Movie

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val posterView: ImageView = findViewById(R.id.details_poster)
        val titleView: TextView = findViewById(R.id.details_title)
        val dateView: TextView = findViewById(R.id.details_release_date)
        val overviewView: TextView = findViewById(R.id.details_overview)
        val voteView: TextView = findViewById(R.id.details_vote)

        val movie = intent.getParcelableExtra<Movie>("movie")

        movie?.let {
            val imageUrl = "https://image.tmdb.org/t/p/w500/"
            titleView.text = it.title ?: "No title"
            dateView.text = it.releaseDate ?: "Unknown"
            overviewView.text = it.overview ?: "No overview"
            voteView.text = "Rating: ${it.voteAverage}"
            Glide.with(this)
                .load("${imageUrl}${it.posterPath}")
                .placeholder(R.mipmap.ic_launcher)
                .into(posterView)
        }
    }
}
