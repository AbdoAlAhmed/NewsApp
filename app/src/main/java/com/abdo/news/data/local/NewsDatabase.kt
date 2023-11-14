package com.abdo.news.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abdo.news.data.model.Article
import com.abdo.news.util.Const.Companion.DATABASE_Name
import com.abdo.news.util.Converters

@Database(entities = [Article::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
open abstract class NewsDatabase : RoomDatabase() {
    abstract fun getDao(): NewsDao

    companion object {
        @Volatile
        private var INSTANCE: NewsDatabase? = null

        operator fun invoke(context: Context) =  INSTANCE ?: synchronized(this){
            INSTANCE ?: createDatabase(context)
        }
        fun createDatabase(context: Context): NewsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    DATABASE_Name
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }

        }
    }


}