package com.example.thealchemistsshelf.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thealchemistsshelf.R
import com.example.thealchemistsshelf.data.Potion
import java.text.NumberFormat

@Composable
fun PotionCard(
    potion: Potion,
    quantity: Int,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = potion.nameRes),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                val unitPrice = NumberFormat.getCurrencyInstance().format(potion.price)
                Text(
                    text = unitPrice,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Text(
                text = stringResource(id = potion.descRes),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    FilledIconButton(
                        onClick = onRemove,
                        modifier = Modifier.size(32.dp),
                        enabled = quantity > 0
                    ) {
                        Icon(Icons.Filled.Remove, contentDescription = "Remove")
                    }

                    Text(
                        text = quantity.toString(),
                        modifier = Modifier.padding(horizontal = 16.dp),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    FilledIconButton(
                        onClick = onAdd,
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = "Add")
                    }
                }

                val subTotal = potion.price * quantity
                val formattedSubTotal = NumberFormat.getCurrencyInstance().format(subTotal)

                Text(
                    text = stringResource(R.string.subtotal_label, formattedSubTotal),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}