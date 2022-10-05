package com.akshaw.cryptocurrency.presentation.coin_detail

import com.akshaw.cryptocurrency.domain.model.Coin
import com.akshaw.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)