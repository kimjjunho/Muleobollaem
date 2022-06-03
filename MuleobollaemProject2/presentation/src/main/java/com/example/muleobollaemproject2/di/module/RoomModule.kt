package com.example.muleobollaemproject2.di.module

import android.content.Context
import androidx.room.Room
import com.example.data.local.dao.MainDao
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
}