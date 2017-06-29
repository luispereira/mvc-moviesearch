package com.vodafone.admin.mvc_movie_notify.features.networking.mocks

import com.vodafone.admin.mvc_movie_notify.features.networking.entities.UpcomingMovieResult
import com.vodafone.admin.mvc_movie_notify.features.networking.helpers.APIService
import retrofit2.mock.BehaviorDelegate
import rx.Observable

/**
 * @author lpereira on 18/10/2016.
 */

class APIClientMock(private val delegate: BehaviorDelegate<APIService>) : APIService {

    override fun upcomingMovies(apiKey: String): Observable<UpcomingMovieResult> {
        return delegate.returningResponse(UpcomingMovieModelMock().mock).upcomingMovies("")
    }
}