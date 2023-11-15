package com.abdo.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdo.news.data.model.Article
import com.abdo.news.data.model.NewsResponse
import com.abdo.news.data.model.Source
import com.abdo.news.repo.NewsRepo
import com.abdo.news.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val repo: NewsRepo) :
    ViewModel() {



    private var _listOfNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val listOFNews: LiveData<Resource<NewsResponse>>
        get() = _listOfNews


    var breakingNewsPage = 1
    var breakingNewsCountry = "us"

    init {
        getBreakingNews()
    }

    private fun getBreakingNews() = viewModelScope.launch {
        val breakingNewsResponse = repo.getBreakingNews(breakingNewsCountry, breakingNewsPage)
        _listOfNews.value = handelBreakingNews(breakingNewsResponse)
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