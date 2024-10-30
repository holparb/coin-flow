package com.holparb.coinflow.crypto.presentation.coin_list

import com.holparb.coinflow.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}