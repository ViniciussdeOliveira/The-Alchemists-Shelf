package com.example.thealchemistsshelf.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thealchemistsshelf.R
import com.example.thealchemistsshelf.data.shopInventory
import com.example.thealchemistsshelf.ui.components.PotionCard
import com.example.thealchemistsshelf.ui.theme.TheAlchemistsShelfTheme
import java.text.NumberFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PotionShopScreen() {
    val cartState = remember { mutableStateMapOf<Int, Int>() }

    val grandTotal = shopInventory.sumOf { potion ->
        val qty = cartState[potion.id] ?: 0
        potion.price * qty
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.title_shop)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val formattedGrandTotal = NumberFormat.getCurrencyInstance().format(grandTotal)

                    Text(
                        text = stringResource(R.string.grand_total_label, formattedGrandTotal),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(shopInventory) { potion ->
                val currentQty = cartState[potion.id] ?: 0

                PotionCard(
                    potion = potion,
                    quantity = currentQty,
                    onAdd = { cartState[potion.id] = currentQty + 1 },
                    onRemove = { if (currentQty > 0) cartState[potion.id] = currentQty - 1 }
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewShop() {
    TheAlchemistsShelfTheme { PotionShopScreen() }
}