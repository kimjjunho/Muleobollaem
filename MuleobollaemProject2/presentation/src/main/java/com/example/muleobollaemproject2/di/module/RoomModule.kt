package com.example.muleobollaemproject2.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.local.dao.CommentDao
import com.example.data.local.dao.MainDao
import com.example.data.local.database.CommentDatabase
import com.example.data.local.database.MainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideMainDatabase(
        @ApplicationContext context: Context
    ): MainDatabase = Room
        .databaseBuilder(
            context,
            MainDatabase::class.java,
            "main"
        ).build()

    @Provides
    fun provideMainDao(
        mainDatabase: MainDatabase
    ):MainDao = mainDatabase.mainDao()

    @Provides
    fun provideCommentDatabase(
        @ApplicationContext context: Context
    ): CommentDatabase = Room.databaseBuilder(
        context,
        CommentDatabase::class.java,
        "comment"
    ).build()

    @Provides
    fun provideCommentDao(
        commentDatabase: CommentDatabase
    ): CommentDao = commentDatabase.commentDao()

}