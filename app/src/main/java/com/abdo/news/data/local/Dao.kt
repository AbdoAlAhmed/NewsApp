package com.abdo.news.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abdo.news.data.model.NewsResponse

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(newsRespones: NewsResponse)


    @Query("SELECT * FROM article")
     fun getArticle():LiveData<NewsResponse>

    @Delete
    suspend fun delete(newRespones: NewsResponse)
}