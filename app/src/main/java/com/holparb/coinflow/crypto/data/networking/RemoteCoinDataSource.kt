package com.holparb.coinflow.crypto.data.networking

import com.holparb.coinflow.core.data.networking.constructUrl
import com.holparb.coinflow.core.data.networking.safeCall
import com.holparb.coinflow.core.domain.util.NetworkError
import com.holparb.coinflow.core.domain.util.Result
import com.holparb.coinflow.core.domain.util.map
import com.holparb.coinflow.crypto.data.mappers.toCoin
import com.holparb.coinflow.crypto.data.mappers.toCoinPrice
import com.holparb.coinflow.crypto.data.networking.dto.CoinHistoryResponseDto
import com.holparb.coinflow.crypto.data.networking.dto.CoinsResponseDto

import com.holparb.coinflow.crypto.domain.datasource.CoinDataSource
import com.holparb.coinflow.crypto.domain.model.Coin
import com.holparb.coinflow.crypto.domain.model.CoinPrice
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.time.ZoneId
import java.time.ZonedDateTime

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { responseDto ->
            responseDto.data.map {
                it.toCoin()
            }
        }
    }

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start.withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        val endMillis = end.withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        return safeCall<CoinHistoryResponseDto> {
            httpClient.get(urlString = constructUrl("/assets/$coinId/history")) {
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end", endMillis)
            }
        }.map {
            it.data.map { coinPriceDto ->
                coinPriceDto.toCoinPrice()
            }
        }
    }
}