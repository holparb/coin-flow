package com.holparb.coinflow.crypto.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.holparb.coinflow.crypto.presentation.model.CoinUi

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUi> = emptyList(),
    val selectedCoin: CoinUi? = null
)
