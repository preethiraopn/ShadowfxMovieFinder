package com.shadowfx.shadowfxmoviefinder.util

import com.google.gson.annotations.SerializedName
import com.shadowfx.shadowfxmoviefinder.data.model.MovieDetail
import com.shadowfx.shadowfxmoviefinder.data.model.SearchResults


object TestUtil {




    fun getNewMovieList():ArrayList<SearchResults.SearchItem?>{
        val searchItem = SearchResults.SearchItem("movie","2016","tt2975590","https://m.media-amazon.com/images/M/MV5BYThjYzcyYzItNTVjNy00NDk0LTgwMWQtYjMwNmNlNWJhMzMyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg","Batman v Superman: Dawn of Justice")
        return arrayListOf(searchItem)
    }


    fun getMovieDetail():MovieDetail {
        val movieDetail = MovieDetail("response","website","production","1990")
        return  movieDetail
    }
}