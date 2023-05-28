package com.example.retrofitandroom.di

import com.example.retrofitandroom.data.UserApi
import com.example.retrofitandroom.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class) //Singleton component means these are application level commponent and only once created throughtout the application
@Module
class NetworkModule{

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build()

    }

    @Provides
    @Singleton
    fun providesUserApi(retrofit: Retrofit): UserApi{
        return retrofit.create(UserApi::class.java)
    }
}

