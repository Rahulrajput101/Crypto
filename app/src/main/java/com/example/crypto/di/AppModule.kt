package com.example.crypto.di

import com.example.crypto.common.Constants
import com.example.crypto.data.remote.CoinApi
import com.example.crypto.data.repositary.CoinRepositoryImp
import com.example.crypto.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi() : CoinApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)

    }

    @Provides
    @Singleton
    fun provideRepository(api: CoinApi) : CoinRepository{
        return CoinRepositoryImp(api)
    }




}