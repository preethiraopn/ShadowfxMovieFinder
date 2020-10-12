package com.shadowfx.shadowfxmoviefinder.ui.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shadowfx.shadowfxmoviefinder.data.model.MovieDetail
import com.shadowfx.shadowfxmoviefinder.data.repositories.MovieDetailRepository

import com.shadowfx.shadowfxmoviefinder.util.ApiException
import com.shadowfx.shadowfxmoviefinder.util.AppConstant
import com.shadowfx.shadowfxmoviefinder.util.NoInternetException
import com.shadowfx.shadowfxmoviefinder.util.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDetailViewModel
@Inject constructor(
    private val repository: MovieDetailRepository
) : ViewModel() {

    val _movieDetailLiveData = MutableLiveData<State<MovieDetail>>()
    val movieDetailLiveData: LiveData<State<MovieDetail>>
        get() = _movieDetailLiveData
    private lateinit var movieDetailResponse: MovieDetail

    fun getMovieDetail(movieTitle: String) {
        _movieDetailLiveData.postValue(State.loading())
        viewModelScope.launch(Dispatchers.IO) {
            try {
                movieDetailResponse = repository.getMovieDetail(movieTitle, AppConstant.API_KEY)
                withContext(Dispatchers.Main) {
                    _movieDetailLiveData.postValue(State.success(movieDetailResponse))
                }
            } catch (e: ApiException) {
                withContext(Dispatchers.Main) {
                    _movieDetailLiveData.postValue(State.error(e.message!!))
                }
            } catch (e: NoInternetException) {
                withContext(Dispatchers.Main) {
                    _movieDetailLiveData.postValue(State.error(e.message!!))
                }
            }
        }
    }

}