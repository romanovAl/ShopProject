package com.plcoding.navigationdrawercompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.navigationdrawercompose.ui.theme.NavigationDrawerComposeTheme

@Composable
fun CashierListScreen(
) {
    Scaffold (
        topBar = {
            AppToolBar(title = "Корзина")
        }
            ){
        Column(
            Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Слива 1шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Вода 5л 2 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Йогурт ирбитский с грушей 3 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Печенье московское 1 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Гель для душа с апельсином 1 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Пакет 2 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Подарочный набор для ребенка 3 года 1 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Игрушечный динозавр 1 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Бекон 1 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Молоко 2 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Чай принцеса Нури 1 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Кофе якобс 1 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Яйца С0 1 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Виноград киш-миш 0.5 кг")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Бананы 3 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Сосиски от дяди Вани 6 шт")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– Сыр 2кг")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "– 8")
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Перейти к заказу")
            }
        }
    }
}

@Preview
@Composable
fun CashierListScreenPreview(){
    NavigationDrawerComposeTheme {
        CashierListScreen(
        )
    }
}