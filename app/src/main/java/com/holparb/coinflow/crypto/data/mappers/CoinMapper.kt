package com.holparb.coinflow.crypto.data.mappers

import com.holparb.coinflow.crypto.data.networking.dto.CoinDto
import com.holparb.coinflow.crypto.domain.model.Coin

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