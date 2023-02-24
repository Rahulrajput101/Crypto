package com.example.crypto.data.remote

import com.example.crypto.data.remote.dto.CoinDetailDto
import com.example.crypto.data.remote.dto.CoinItemDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinItemDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetail(
        @Path("coinId") coinId : String
    ) : CoinDetailDto




}