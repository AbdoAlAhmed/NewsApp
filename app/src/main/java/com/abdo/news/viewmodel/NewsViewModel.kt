package com.abdo.news.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdo.news.data.model.NewsResponse
import com.abdo.news.repo.NewsRepo
import com.abdo.news.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val repo: NewsRepo) :
    ViewModel() {

    private var listOfNews = MutableStateFlow<Resource<NewsResponse>>(null!!)

    var breakingNewsPage = 1
    var breakingNewsCountry = "eg"


    fun getBreakingNews() = viewModelScope.launch {
        val breakingNewsResponse = repo.getBreakingNews(breakingNewsCountry, breakingNewsPage)
        handelBreakingNews(breakingNewsResponse)
    }

    private fun handelBreakingNews(response: Response<NewsResponse>): Resource<NewsResponse> {
        return if (response.isSuccessful) {
            response.body().let {
                Resource.Success(it)
            }

        } else {
            Resource.Error(response.message())
        }
    }


}