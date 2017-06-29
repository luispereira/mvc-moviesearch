package com.vodafone.admin.mvc_movie_notify.features.networking

import com.vodafone.admin.mvc_movie_notify.features.networking.entities.UpcomingMovieResult
import com.vodafone.admin.mvc_movie_notify.features.networking.helpers.APIService
import com.vodafone.admin.mvc_movie_notify.features.networking.helpers.ApiClient
import com.vodafone.admin.mvc_movie_notify.features.shared.Constants
import rx.Observable

/**
 * @author lpereira on 28/06/2017.
 */

class NetworkModel{

    private val service: APIService

    constructor(){
        service = ApiClient().getClient().create(APIService::class.java)
    }

    fun upcomingMovies() : Observable<UpcomingMovieResult>{
        return service.upcomingMovies(Constants.API.TOKEN)
    }
}
