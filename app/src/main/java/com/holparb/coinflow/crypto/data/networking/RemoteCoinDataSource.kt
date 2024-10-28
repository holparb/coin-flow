package com.holparb.coinflow.crypto.data.networking

import com.holparb.coinflow.core.data.networking.constructUrl
import com.holparb.coinflow.core.data.networking.safeCall
import com.holparb.coinflow.core.domain.util.NetworkError
import com.holparb.coinflow.core.domain.util.Result
import com.holparb.coinflow.core.domain.util.map
import com.holparb.coinflow.crypto.data.mappers.toCoin
import com.holparb.coinflow.crypto.data.networking.dto.CoinsResponseDto

import com.holparb.coinflow.crypto.domain.datasource.CoinDataSource
import com.holparb.coinflow.crypto.domain.model.Coin
import io.ktor.client.HttpClient
import io.ktor.client.request.get

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
}