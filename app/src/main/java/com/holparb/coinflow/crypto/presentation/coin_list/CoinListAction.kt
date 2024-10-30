package com.holparb.coinflow.crypto.presentation.coin_list

import com.holparb.coinflow.crypto.presentation.model.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi): CoinListAction
}