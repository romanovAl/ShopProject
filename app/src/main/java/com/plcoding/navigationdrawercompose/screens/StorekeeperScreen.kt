package com.plcoding.navigationdrawercompose.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.navigationdrawercompose.ui.theme.NavigationDrawerComposeTheme

@Composable
fun StorekeeperScreen(
) {
    Scaffold{
        Column(
            Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            AppToolBar(title = "Бухгалтер")
            Text(text = "Баланс : \nНаличные - 155 000руб \nБезналичные- 250 000руб", fontSize = 25.sp, color = Color.Gray )
            Spacer(modifier = Modifier.size(48.dp))
            Row(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = "Слива      50кг    5000руб")
                Spacer(modifier = Modifier.size(16.dp))
                OutlinedButton(onClick = {}) {
                    Text(text = "Одобрить")
                }
            }
            Row(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = "Сыр       20шт     4900руб")
                Spacer(modifier = Modifier.size(16.dp))
                OutlinedButton(onClick = {}) {
                    Text(text = "Одобрить")
                }
            }
            Row(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = "Кофе якобс       25шт  9300руб")
                Spacer(modifier = Modifier.size(16.dp))
                OutlinedButton(onClick = {}) {
                    Text(text = "Одобрить")
                }
            }
            Row(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = "Яйца С0       50шт 5050руб")
                Spacer(modifier = Modifier.size(16.dp))
                OutlinedButton(onClick = {}) {
                    Text(text = "Одобрить")
                }
            }
            Row(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = "Бананы       23кг  3013руб")
                Spacer(modifier = Modifier.size(16.dp))
                OutlinedButton(onClick = {}) {
                    Text(text = "Одобрить")
                }
            }
        }
    }
}

@Preview
@Composable
fun StorekeeperScreenPreview(){
    NavigationDrawerComposeTheme {
        StorekeeperScreen(
        )
    }
}