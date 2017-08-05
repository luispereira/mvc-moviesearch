package com.vodafone.admin.mvc_movie_notify.features.networking.helpers

import com.vodafone.admin.mvc_movie_notify.features.networking.entities.UpcomingMovieResult
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author lpereira on 28/06/2017.
 */

interface APIService{

    @GET("movies/upcoming")
    fun upcomingMovies(@Query("api_key") apiKey: String): io.reactivex.Observable<UpcomingMovieResult>
}
