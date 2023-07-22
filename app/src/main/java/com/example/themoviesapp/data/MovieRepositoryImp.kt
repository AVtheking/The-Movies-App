package com.example.themoviesapp.data

import com.example.themoviesapp.data.datasource.MovieCacheDataSource
import com.example.themoviesapp.data.datasource.MovieLocalDataSource
import com.example.themoviesapp.data.datasource.MovieRemoteDataSource
import com.example.themoviesapp.data.model.Movie
import com.example.themoviesapp.domain.repository.MovieRepository

class MovieRepositoryImp(
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
):MovieRepository {
    override suspend fun getMovies(): List<Movie>?{
        return getMoviesFromCache()
    }



    override suspend fun updateMovies(): List<Movie>?{
         val newListOFMovies=getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovetoDb(newListOFMovies)
        movieCacheDataSource.saveMovieToCache(newListOFMovies)
        return  newListOFMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
           var movieList: List<Movie> = emptyList()
         try {
             val response = movieRemoteDataSource.getMovies()
             val body = response.body()
             if (body != null) {
                 movieList = body.movies
             }
         }catch (exception:java.lang.Exception){

         }
        return movieList
    }
    suspend fun getMoviesFromRoom(): List<Movie> {
        var movieList: List<Movie> = emptyList() // Initialize with an empty list

        try {
            movieList = movieLocalDataSource.getMovieFromDb()
        } catch (exception: Exception) {
            // Handle the exception
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMovetoDb(movieList)
        }

        return movieList
    }
    suspend fun getMoviesFromCache(): List<Movie> {
        var movieList: List<Movie> = emptyList()
           try {
               movieList=movieCacheDataSource.getMoviesFromCache()
           }catch (exception:Exception){

           }
        if(movieList.isNotEmpty())
            return movieList
        else
        {
            movieList=getMoviesFromRoom()
            movieCacheDataSource.saveMovieToCache(movieList)
        }
        return movieList
    }
}