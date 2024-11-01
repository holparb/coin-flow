package com.holparb.coinflow.crypto.domain.datasource

import com.holparb.coinflow.core.domain.util.NetworkError
import com.holparb.coinflow.core.domain.util.Result
import com.holparb.coinflow.crypto.domain.model.Coin

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}