package com.akshaw.cryptocurrency.domain.repository

import com.akshaw.cryptocurrency.data.remote.dto.CoinDetailDto
import com.akshaw.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}