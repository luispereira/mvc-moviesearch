package com.vodafone.admin.mvc_movie_notify.features.networking

import com.vodafone.admin.mvc_movie_notify.features.networking.entities.MovieEntity
import com.vodafone.admin.mvc_movie_notify.features.networking.entities.UpcomingMovieResult
import com.vodafone.admin.mvc_movie_notify.features.networking.helpers.APIService
import com.vodafone.admin.mvc_movie_notify.features.networking.helpers.ApiClient
import com.vodafone.admin.mvc_movie_notify.features.shared.Constants
import com.vodafone.admin.mvc_movie_notify.features.shared.CustomListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author lpereira on 28/06/2017.
 */

class NetworkModel(val service: APIService = ApiClient().getClient().create(APIService::class.java)) {
    private var movies: UpcomingMovieResult? = null

    fun upcomingMovies(listener: CustomListener) {
        service.upcomingMovies(Constants.TOKEN)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { movies ->
                    this.movies = movies
                    listener.resultsReady()
                }
    }

    fun movies(): List<MovieEntity>? = movies?.results
}
