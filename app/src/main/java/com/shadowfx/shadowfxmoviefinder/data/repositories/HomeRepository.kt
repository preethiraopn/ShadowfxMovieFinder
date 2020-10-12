package com.shadowfx.shadowfxmoviefinder.data.repositories;

import com.shadowfx.shadowfxmoviefinder.data.model.SearchResults
import com.shadowfx.shadowfxmoviefinder.data.network.ApiInterface
import com.shadowfx.shadowfxmoviefinder.data.network.SafeApiRequest
import com.shadowfx.shadowfxmoviefinder.testing.OpenForTesting
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
@OpenForTesting
class HomeRepository
@Inject constructor(
    private val api: ApiInterface
) : SafeApiRequest() {

    suspend fun getMovies(
        searchTitle: String,
        apiKey: String,
        pageIndex: Int
    ): SearchResults {

        return apiRequest { api.getSearchResultData(searchTitle, apiKey, pageIndex) }
    }


}