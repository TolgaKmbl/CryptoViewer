package com.tolgakumbul.cryptoviewer

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CryptoViewerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}