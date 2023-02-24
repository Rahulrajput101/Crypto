package com.example.crypto.data.repositary

import com.example.crypto.data.remote.CoinApi
import com.example.crypto.data.remote.dto.CoinDetailDto
import com.example.crypto.data.remote.dto.CoinItemDto
import com.example.crypto.domain.model.CoinItem
import com.example.crypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    val api : CoinApi
) : CoinRepository{
    override suspend fun getCoin(): List<CoinItemDto> {
        return api.getCoins()
    }

    override suspend fun getCoinDetail(coinId : String): CoinDetailDto {
        return api.getCoinDetail(coinId)
    }
}