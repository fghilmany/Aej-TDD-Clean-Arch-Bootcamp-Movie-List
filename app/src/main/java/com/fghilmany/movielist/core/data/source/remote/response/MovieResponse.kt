package com.fghilmany.movielist.core.data.source.remote.response

data class MovieResponse(
	val page: Int? = null,
	val totalPages: Int? = null,
	val results: List<Results>? = null,
	val totalResults: Int? = null
)

data class Results(
	val overview: String? = null,
	val originalLanguage: String? = null,
	val originalTitle: String? = null,
	val video: Boolean? = null,
	val title: String? = null,
	val genreIds: List<Int>? = null,
	val posterPath: String? = null,
	val backdropPath: String? = null,
	val releaseDate: String? = null,
	val popularity: Double? = null,
	val voteAverage: Float? = null,
	val id: Int? = null,
	val adult: Boolean? = null,
	val voteCount: Int? = null
)

