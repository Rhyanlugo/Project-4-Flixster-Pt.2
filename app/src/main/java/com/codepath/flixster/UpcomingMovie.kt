package com.codepath.flixster

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class UpcomingMovieResult(
	@SerialName("results")
	val results: List<TopRatedMovie>?
)

@Keep
@Serializable
data class UpcomingMovie(
	@SerialName("poster_path")
	val upcomingMoviePoster: String?,

	@SerialName("overview")
	val upcomingMovieDescription: String?,

	@SerialName("release_date")
	val upcomingMovieReleaseDate: String?,

	@SerialName("title")
	val upcomingMovieTitle: String?,

	@SerialName("vote_count")
	val upcomingMovieVoteCount: Int?,

	@SerialName("vote_average")
	val upcomingMovieVoteAverage: Double?
) : java.io.Serializable
{
	val moviePosterURL = "https://image.tmdb.org/t/p/w500${upcomingMoviePoster}"
}