package com.abdo.news

import android.app.Application
import com.abdo.news.data.local.NewsDatabase
import com.abdo.news.di.newsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class NewsApplication: Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NewsApplication)
            modules(newsModule)
        }

    }
}