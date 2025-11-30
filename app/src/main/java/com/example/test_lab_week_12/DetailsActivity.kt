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

        val poster: ImageView = findViewById(R.id.details_poster)
        val title: TextView = findViewById(R.id.details_title)
        val date: TextView = findViewById(R.id.details_release_date)
        val rating: TextView = findViewById(R.id.details_vote)
        val overview: TextView = findViewById(R.id.details_overview)

        val movie = intent.getParcelableExtra<Movie>("movie")

        movie?.let {
            val imageUrl = "https://image.tmdb.org/t/p/w500/${it.posterPath}"

            Glide.with(this).load(imageUrl).into(poster)

            title.text = it.title ?: "No Title"
            date.text = "Release: ${it.releaseDate ?: "-"}"
            rating.text = "Rating: ${it.voteAverage}"
            overview.text = it.overview ?: "No overview available"
        }
    }
}
