package com.example.crypto.data.remote.dto

import com.example.crypto.domain.model.CoinItem

data class CoinItemDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)


fun CoinItemDto.toCoin() : CoinItem{
    return CoinItem(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol =symbol
    )
}