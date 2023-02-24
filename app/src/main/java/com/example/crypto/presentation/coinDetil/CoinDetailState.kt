package com.example.crypto.presentation.coinDetil

import com.example.crypto.domain.model.CoinDetail

data class CoinDetailState(
    val coin : CoinDetail? = null,
    val isLoading : Boolean = false,
    val error : String = ""


)
