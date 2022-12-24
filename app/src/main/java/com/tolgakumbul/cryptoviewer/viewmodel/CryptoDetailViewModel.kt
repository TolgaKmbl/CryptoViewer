package com.tolgakumbul.cryptoviewer.viewmodel

import androidx.lifecycle.ViewModel
import com.tolgakumbul.cryptoviewer.model.Crypto
import com.tolgakumbul.cryptoviewer.repository.CryptoRepository
import com.tolgakumbul.cryptoviewer.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {

    suspend fun getCrypto(id: String): Resource<Crypto> {
        return repository.getCrypto(id)
    }

}