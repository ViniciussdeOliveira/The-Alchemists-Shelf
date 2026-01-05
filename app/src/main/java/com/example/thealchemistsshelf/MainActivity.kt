package com.example.thealchemistsshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.thealchemistsshelf.ui.screens.PotionShopScreen
import com.example.thealchemistsshelf.ui.theme.TheAlchemistsShelfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheAlchemistsShelfTheme {
                PotionShopScreen()
            }
        }
    }
}