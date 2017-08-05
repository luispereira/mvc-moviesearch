package com.vodafone.admin.mvc_movie_notify.features.movies

import com.vodafone.admin.mvc_movie_notify.features.networking.NetworkModel
import com.vodafone.admin.mvc_movie_notify.features.shared.CustomListener

/**
 * @author lpereira on 05/08/2017.
 */

class MovieController(val networkModel: NetworkModel = NetworkModel(), val movieActivity: MovieActivity) : CustomListener {

    fun refreshClick() {
        networkModel.upcomingMovies(this)
    }

    override fun resultsReady() {
        //instead of telling the view here, we could also implement other listener and call it
        movieActivity.updateMovie()
    }
}
