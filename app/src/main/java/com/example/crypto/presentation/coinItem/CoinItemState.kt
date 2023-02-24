package com.example.crypto.presentation.coinItem

import com.example.crypto.domain.model.CoinItem

data class CoinItemState(

    val isLoading : Boolean = false,
    val data : List<CoinItem> = emptyList(),
    val error: String = ""



)
