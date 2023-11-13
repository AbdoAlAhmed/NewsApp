package com.abdo.news.data.repo

import com.abdo.news.data.local.NewsDatabase
import com.abdo.news.data.model.NewsResponse
import com.abdo.news.data.remote.RetrofitInstance

class NewsRepo(
    private val remote: RetrofitInstance,
    private val local: NewsDatabase
) {
    suspend fun getBreakingNews(country: String, page: Int) =
        remote.api.getBreakingNews(country, page)


    suspend fun getSearchNews(query: String, page: Int) =
        remote.api.searchNews(query, page)

    suspend fun insertSavedNews(response: NewsResponse) = local.getDao().insert(response)

    fun getSavedNews() = local.getDao().getArticle()

    suspend fun deleteNews(newsResponse: NewsResponse) = local.getDao().delete(newsResponse)
}