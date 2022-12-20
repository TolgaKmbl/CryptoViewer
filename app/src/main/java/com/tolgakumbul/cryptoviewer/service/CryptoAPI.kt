package com.tolgakumbul.cryptoviewer.service

import com.tolgakumbul.cryptoviewer.model.Crypto
import com.tolgakumbul.cryptoviewer.model.CryptoList
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoAPI {

    // You can change the uri and the query params based on your api call
    @GET("prices")
    suspend fun getCryptoList(@Query("key") key: String): CryptoList

    @GET("currencies")
    suspend fun getCrypto(
        @Query("key") key: String,
        @Query("ids") id: String,
        @Query("attributes") attributes: String
    ): Crypto
}