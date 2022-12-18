package com.tolgakumbul.cryptoviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.tolgakumbul.cryptoviewer.ui.theme.CryptoViewerTheme
import com.tolgakumbul.cryptoviewer.view.CryptoDetailScreen
import com.tolgakumbul.cryptoviewer.view.CryptoListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoViewerTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "crypto_list_screen") {
                    composable("crypto_list_screen") {
                        //CryptoListScreen
                        CryptoListScreen(navController = navController)
                    }
                    composable("crypto_detail_screen/{cryptoId}/{cryptoPrice}", arguments = listOf(
                        navArgument("cryptoId") {
                            type = NavType.StringType
                        },
                        navArgument("cryptoPrice") {
                            type = NavType.StringType
                        }
                    )) {
                        //CryptoDetailScreen
                        val cryptoId = remember {
                            it.arguments?.getString("cryptoId")
                        }
                        val cryptoPrice = remember {
                            it.arguments?.getString("cryptoPrice")
                        }
                        CryptoDetailScreen(
                            id = cryptoId,
                            price = cryptoPrice,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
