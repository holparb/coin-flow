package com.holparb.coinflow.crypto.data.mappers

import com.holparb.coinflow.crypto.data.networking.dto.CoinDto
import com.holparb.coinflow.crypto.data.networking.dto.CoinPriceDto
import com.holparb.coinflow.crypto.domain.model.Coin
import com.holparb.coinflow.crypto.domain.model.CoinPrice
import java.time.Instant
import java.time.ZoneId

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.systemDefault())
    )
}