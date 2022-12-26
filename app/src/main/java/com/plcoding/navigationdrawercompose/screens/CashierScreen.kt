package com.plcoding.navigationdrawercompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.navigationdrawercompose.ui.theme.NavigationDrawerComposeTheme

@Composable
fun CashierScreen(
    productName: String,
    productPrice: Int,
    onSellByCacheClick: () -> Unit,
    onSellByCardClick: () -> Unit
) {
    Scaffold{
        Column(
            Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Название: $productName")
            Spacer(Modifier.height(32.dp))
            Text(text = "Цена: $productPrice")
            Spacer(Modifier.height(32.dp))
            Row {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = onSellByCacheClick
                ) {
                    Text(text = "Наличные")
                }
                Spacer(Modifier.width(16.dp))
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = onSellByCardClick
                ) {
                    Text(text = "Безнал")
                }
            }
        }
    }
}

@Preview
@Composable
fun CashierScreenPreview(){
    NavigationDrawerComposeTheme {
        CashierScreen(
            productName = "Торт Муравейник",
            productPrice = 100,
            onSellByCacheClick = {},
            onSellByCardClick = {}
        )
    }
}