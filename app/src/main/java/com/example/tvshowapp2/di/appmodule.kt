package com.example.tvshowapp2.di

import com.example.tvshowapp2.api.apiservice
import com.example.tvshowapp2.helper.constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object appmodule {
    @Provides
    fun providebaseurl()= constant.baseurl


    @Provides
    @Singleton
    fun providesRetrofitinstane(Base_Url:String): apiservice =
        Retrofit.Builder().baseUrl(Base_Url).
        addConverterFactory(GsonConverterFactory.create()).
        build().
        create(apiservice::class.java)



}