package com.example.muleobollaemproject2.di.module

import android.util.Log
import com.example.data.remote.network.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.w3c.dom.Comment
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor{ Log.v("HTTP",it)}
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://34.209.138.0:8000/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideMainApi(
        retrofit: Retrofit
    ):MainAPI =
        retrofit.create(MainAPI::class.java)

    @Singleton
    @Provides
    fun provideLoginApi(
        retrofit: Retrofit
    ):LoginAPI =
        retrofit.create(LoginAPI::class.java)

    @Singleton
    @Provides
    fun provideSignUpApi(
        retrofit: Retrofit
    ): SignUpAPI =
        retrofit.create(SignUpAPI::class.java)

    @Singleton
    @Provides
    fun provideSendWriteApi(
        retrofit: Retrofit
    ):WriteAPI =
        retrofit.create(WriteAPI::class.java)

    @Singleton
    @Provides
    fun provideDeletePostApi(
        retrofit: Retrofit
    ): DeleteAPI =
        retrofit.create(DeleteAPI::class.java)

    @Singleton
    @Provides
    fun providePutPostApi(
        retrofit: Retrofit
    ): PutAPI =
        retrofit.create(PutAPI::class.java)

    @Singleton
    @Provides
    fun provideCheckIdApi(
        retrofit: Retrofit
    ): CheckIdAPI =
        retrofit.create(CheckIdAPI::class.java)

    @Singleton
    @Provides
    fun provideCommentApi(
        retrofit: Retrofit
    ): CommentAPI =
        retrofit.create(CommentAPI::class.java)
}