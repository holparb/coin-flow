package com.holparb.coinflow.di

import com.holparb.coinflow.core.data.networking.HttpClientFactory
import com.holparb.coinflow.crypto.data.networking.RemoteCoinDataSource
import com.holparb.coinflow.crypto.domain.datasource.CoinDataSource
import com.holparb.coinflow.crypto.presentation.coin_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}