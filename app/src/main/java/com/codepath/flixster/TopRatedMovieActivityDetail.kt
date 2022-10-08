package com.codepath.flixster

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class TopRatedMovieActivityDetail : AppCompatActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_top_rated_movie)

		val moviePoster = findViewById<ImageView>(R.id.top_rated_movie_poster)
		val movieTitle = findViewById<TextView>(R.id.top_rated_movie_title)
		val movieReleaseDate = findViewById<TextView>(R.id.top_rated_release_date)
		val movieRating = findViewById<RatingBar>(R.id.top_rated_movie_rating)
		val movieVotes = findViewById<TextView>(R.id.top_rated_movie_votes)
		val movieDescription = findViewById<TextView>(R.id.top_rated_movie_description)

		val topRatedMovie = intent.getSerializableExtra(TOP_RATED_MOVIE_EXTRA) as TopRatedMovie

		movieTitle.text = topRatedMovie.topRatedMovieTitle

		movieReleaseDate.text =
			SpannableString("Release Date: ${topRatedMovie.topRatedMovieReleaseDate}").setSpan(
				Typeface.BOLD, 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
			).toString()

		movieRating.rating = topRatedMovie.topRatedMovieVoteAverage!!.toFloat()
		movieVotes.text = "${topRatedMovie.topRatedMovieVoteCount.toString()} votes"

		Glide.with(this)
			.load(topRatedMovie.moviePosterURL)
			.placeholder(android.R.drawable.ic_menu_gallery)
			.into(moviePoster)

		movieDescription.text = topRatedMovie.topRatedMovieDescription
	}
}