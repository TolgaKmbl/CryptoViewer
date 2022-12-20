package com.tolgakumbul.cryptoviewer.repository

import com.tolgakumbul.cryptoviewer.model.Crypto
import com.tolgakumbul.cryptoviewer.model.CryptoList
import com.tolgakumbul.cryptoviewer.service.CryptoAPI
import com.tolgakumbul.cryptoviewer.util.Constants.API_KEY
import com.tolgakumbul.cryptoviewer.util.Constants.CALL_ATTRIBUTES
import com.tolgakumbul.cryptoviewer.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor(private val api: CryptoAPI) {

    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList(API_KEY)
        } catch (e: Exception) {
            return Resource.Error("An error has occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id: String): Resource<Crypto> {
        val response = try {
            api.getCrypto(API_KEY, id, CALL_ATTRIBUTES)
        } catch (e: Exception) {
            return Resource.Error("An error has occurred.")
        }
        return Resource.Success(response)
    }
}