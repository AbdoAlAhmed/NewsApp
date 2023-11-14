package com.abdo.news.di

import androidx.room.Room
import com.abdo.news.data.local.NewsDatabase
import com.abdo.news.data.remote.RetrofitInstance
import com.abdo.news.repo.NewsRepo
import com.abdo.news.viewmodel.NewsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsModule = module {
//
    single {
        Room.databaseBuilder(
            androidContext(),
            NewsDatabase::class.java,
            "your_database_name"
        ).build()
    }

//    single { get<NewsDatabase>().getDao() }
//
////    single { NewsDatabase.createDatabase(androidContext()) }
////    single { get<NewsDatabase>().getDao() }
    single { RetrofitInstance() }
    factory { NewsRepo(get()) }
    viewModel() {
        NewsViewModel(get())
    }

}