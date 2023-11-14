package com.abdo.news.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.abdo.news.data.local.NewsDatabase
import com.abdo.news.util.Const


fun provideDatabase(context: Context): RoomDatabase =
    Room.databaseBuilder(
        context,
        NewsDatabase::class.java,
        Const.DATABASE_Name
    )
        .fallbackToDestructiveMigration()
        .build()


fun provideDao(newsDatabase: NewsDatabase) = newsDatabase.getDao()