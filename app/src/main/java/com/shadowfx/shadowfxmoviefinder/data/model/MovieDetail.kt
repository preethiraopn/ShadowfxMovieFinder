package com.shadowfx.shadowfxmoviefinder.data.model;

import com.google.gson.annotations.SerializedName

data class MovieDetail(

    @SerializedName("Response")
    var response: String?,

    @SerializedName("Website")
    var website: String?,

    @SerializedName("Production")
    var production: String? = null,

    @SerializedName("Year")
    var year: String? =  null,

    @SerializedName("BoxOffice")
    var boxoffice: String? = null,

    @SerializedName("DVD")
    var dvd: String? = null,

    @SerializedName("Type")
    var type: String? = null,

    @SerializedName("imdbID")
    var imdbid: String? = null,

    @SerializedName("imdbVotes")
    var imdbvotes: String? = null,

    @SerializedName("imdbRating")
    var imdbrating: String? = null,

    @SerializedName("Metascore")
    var metascore: String ?= null,

    @SerializedName("Ratings")
    var ratings: List<Ratings>? = null,

    @SerializedName("Poster")
    var poster: String? = null,

    @SerializedName("Awards")
    var awards: String?  = null,

    @SerializedName("Country")
    var country: String?  = null,

    @SerializedName("Language")
    var language: String? = null,

    @SerializedName("Plot")
    var plot: String? = null,

    @SerializedName("Actors")
    var actors: String ? = null,

    @SerializedName("Writer")
    var writer: String? = null,

    @SerializedName("Director")
    var director: String? = null,

    @SerializedName("Genre")
    var genre: String?= null,

    @SerializedName("Runtime")
    var runtime: String?  = null,

    @SerializedName("Released")
    var released: String? = null,

    @SerializedName("Rated")
    var rated: String?  = null,



    @SerializedName("Title")
    var title: String? = null

) {
    data class Ratings(
        @SerializedName("Value")
        var value: String,
        @SerializedName("Source")
        var source: String
    )
}

