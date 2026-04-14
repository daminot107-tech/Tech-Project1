package com.example.imdbclone.module

import androidx.room.PrimaryKey
import com.example.imdbclone.remote.MovieApi
import com.example.imdbclone.utils.AuthInterceptor
import com.example.imdbclone.utils.Constant.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Singleton
    @Provides
    fun provideRetroFitBuilder():Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }
    @Singleton
    @Provides
    fun provideOkhttp(authInterceptor: AuthInterceptor):OkHttpClient{
        val loggingInterceptor=HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor).addInterceptor(authInterceptor).build()

    }
    @Singleton
    @Provides
    fun  provideMovieApi(retrofitBuilder: Builder, okHttpClient: OkHttpClient):MovieApi{
        return retrofitBuilder.client(okHttpClient).build().create(MovieApi::class.java)
    }
}