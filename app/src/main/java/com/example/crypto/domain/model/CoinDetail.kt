package com.example.crypto.domain.model

import com.example.crypto.data.remote.dto.Tag
import com.example.crypto.data.remote.dto.Team

data class CoinDetail(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<Team>,
    val description: String



    )
