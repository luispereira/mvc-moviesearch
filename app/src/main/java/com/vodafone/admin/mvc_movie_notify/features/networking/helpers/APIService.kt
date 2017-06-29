package com.vodafone.admin.mvc_movie_notify.features.networking.helpers

import com.vodafone.admin.mvc_movie_notify.features.networking.entities.UpcomingMovieResult
import retrofit2.http.GET
import rx.Observable

/**
 * @author lpereira on 28/06/2017.
 */

interface APIService{

    @GET("movie/upcoming")
    fun upcomingMovies(apiKey: String): Observable<UpcomingMovieResult>

}
