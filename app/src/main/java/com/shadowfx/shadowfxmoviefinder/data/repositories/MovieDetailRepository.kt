package com.shadowfx.shadowfxmoviefinder.data.repositories;

import com.shadowfx.shadowfxmoviefinder.data.model.MovieDetail
import com.shadowfx.shadowfxmoviefinder.data.network.ApiInterface
import com.shadowfx.shadowfxmoviefinder.data.network.SafeApiRequest
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MovieDetailRepository
@Inject constructor(private val api: ApiInterface) : SafeApiRequest() {
    suspend fun getMovieDetail(
        title: String,
        apiKey: String): MovieDetail {
        return apiRequest { api.getMovieDetailData(title, apiKey) }
    }


}