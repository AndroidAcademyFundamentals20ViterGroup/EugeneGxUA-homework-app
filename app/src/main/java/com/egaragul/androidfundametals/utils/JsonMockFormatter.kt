package com.egaragul.androidfundametals.utils

import android.content.Context
import com.egaragul.androidfundametals.ui.movies.data.Actor
import com.egaragul.androidfundametals.ui.movies.data.Genre
import com.egaragul.androidfundametals.ui.movies.data.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object JsonMockFormatter {

    private val jsonFormat = Json { ignoreUnknownKeys = true }

    internal suspend fun loadMovies(context: Context) : List<Movie> = withContext(Dispatchers.IO) {
        val genreMap = loadGenres(context)
        val actorsMap = loadActors(context)

        val data = readAssetFileToString(context, "data.json")
        parseMovies(data, genreMap, actorsMap)
    }

    private suspend fun loadGenres(context: Context) : List<Genre> = withContext(Dispatchers.IO) {
        val data = readAssetFileToString(context, "genres.json")
        parseGenres(data)
    }

    private suspend fun loadActors(context: Context) : List<Actor> = withContext(Dispatchers.IO) {
        val data = readAssetFileToString(context, "people.json")
        parseActors(data)
    }

    private fun readAssetFileToString(context: Context, fileName : String) : String {
        val stream = context.assets.open(fileName)
        return stream.bufferedReader().readText()
    }

    internal fun parseGenres(jsonString : String) : List<Genre> {
        val jsonGenre = jsonFormat.decodeFromString<List<JsonGenre>>(jsonString)
        return jsonGenre.map { jsonGenreItem -> Genre(id = jsonGenreItem.id, name = jsonGenreItem.name) }
    }

    internal fun parseActors(jsonString: String) : List<Actor> {
        val jsonActor = jsonFormat.decodeFromString<List<JsonActor>>(jsonString)
        return jsonActor.map { jsonActorItem -> Actor(id = jsonActorItem.id, name = jsonActorItem.name, imageUrl = jsonActorItem.profilePicture) }
    }

    internal fun parseMovies(
        jsonString: String,
        genreData: List<Genre>,
        actors: List<Actor>
    ): List<Movie> {
        val genresMap = genreData.associateBy(Genre::id)
        val actorsMap = actors.associateBy(Actor::id)

        val jsonMovies = jsonFormat.decodeFromString<List<JsonMovie>>(jsonString)

        return jsonMovies.map { jsonMovie ->
            @Suppress("unused")
            Movie(
                id = jsonMovie.id,
                title = jsonMovie.title,
                storyLine = jsonMovie.overview,
                imageUrl = jsonMovie.posterPicture,
                detailImageUrl = jsonMovie.backdropPicture,
                rating = (jsonMovie.ratings / 2).toInt(),
                reviewCount = jsonMovie.votesCount,
                pgAge = if (jsonMovie.adult) 16 else 13,
                runningTime = jsonMovie.runtime,
                genres = jsonMovie.genreIds.map { id ->
                    genresMap[id].orThrow { IllegalArgumentException("Genre not found") }
                },
                actors = jsonMovie.actors.map { id ->
                    actorsMap[id].orThrow { IllegalArgumentException("Actor not found") }
                },
                isLiked = false
            )
        }
    }

    private fun <T : Any> T?.orThrow(lambda: () -> Exception): T {
        return this ?: throw lambda()
    }
}