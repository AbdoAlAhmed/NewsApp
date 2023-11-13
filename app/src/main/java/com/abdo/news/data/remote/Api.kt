package com.abdo.news.data.remote

import com.abdo.news.data.model.NewsResponse
import com.abdo.news.util.Constances.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        country: String = "eg",
        @Query("page")
        page: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ):Response<NewsResponse>
    @GET("v2/everything")
    suspend fun searchNews(
        @Query("q")
        search: String ,
        @Query("page")
        page: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}