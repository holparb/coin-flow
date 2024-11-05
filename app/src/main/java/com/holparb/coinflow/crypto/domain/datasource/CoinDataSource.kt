package com.holparb.coinflow.crypto.domain.datasource

import com.holparb.coinflow.core.domain.util.NetworkError
import com.holparb.coinflow.core.domain.util.Result
import com.holparb.coinflow.crypto.domain.model.Coin
import com.holparb.coinflow.crypto.domain.model.CoinPrice
import java.time.ZonedDateTime

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>
}