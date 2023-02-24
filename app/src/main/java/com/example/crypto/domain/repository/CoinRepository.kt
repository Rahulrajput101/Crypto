package com.example.crypto.domain.repository

import com.example.crypto.data.remote.dto.CoinDetailDto
import com.example.crypto.data.remote.dto.CoinItemDto
import com.example.crypto.domain.model.CoinItem

interface CoinRepository {


    suspend fun getCoin() : List<CoinItemDto>

    suspend fun getCoinDetail(coinId : String) : CoinDetailDto
}