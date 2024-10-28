package com.holparb.coinflow.crypto.presentation.coin_list

import com.holparb.coinflow.crypto.presentation.model.CoinUi

sealed interface CoinListEvent {
    data class OnCoinClick(val coinUi: CoinUi): CoinListEvent
}