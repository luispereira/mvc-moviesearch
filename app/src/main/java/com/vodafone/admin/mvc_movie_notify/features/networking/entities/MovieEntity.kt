package com.vodafone.admin.mvc_movie_notify.features.networking.entities

/**
 * @author lpereira on 28/06/2017.
 */

data class MovieEntity(val id: Long,
                       val vote_count: Long,
                       val vote_average: Float,
                       val title: String,
                       val release_date: String)
