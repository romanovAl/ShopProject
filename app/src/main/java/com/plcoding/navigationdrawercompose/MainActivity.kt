package com.plcoding.navigationdrawercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.plcoding.navigationdrawercompose.data.db.DB
import com.plcoding.navigationdrawercompose.data.dbEntities.Order
import com.plcoding.navigationdrawercompose.data.dbEntities.Product
import com.plcoding.navigationdrawercompose.screens.AccountantScreen
import com.plcoding.navigationdrawercompose.screens.CashierScreen
import com.plcoding.navigationdrawercompose.screens.StorekeeperScreen
import com.plcoding.navigationdrawercompose.ui.theme.NavigationDrawerComposeTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


enum class Screen {
    Home,
    Accountant,
    Cashier,
    Storekeeper
}

interface listener{
    fun sellProduct(product: Product, nalBeznal: NalBeznal)
    fun rejectSell()
    fun order(order : Order)
    fun approveOrder(order: Order)
}

enum class NalBeznal(){
    Nal,
    Beznal
}

class MainActivity : ComponentActivity(), listener {
    val db = DB.buildDatabase(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var curScreen by rememberSaveable {
                mutableStateOf(Screen.Home)
            }
            BackHandler() {
                curScreen = Screen.Home
            }
//            NavigationDrawerComposeTheme {
//                MainScreen(
//                    onClickSomewhere = {
//                        curScreen = it
//                    },
//                    content = {
//                        when (curScreen) {
//                            Screen.Home -> MainContent()
//                            Screen.Accountant -> AccountantScreen()
//                            Screen.Cashier -> CashierScreen()
//                            Screen.Storekeeper -> StorekeeperScreen()
//                        }
//                    }
//                )
//            }
        }
    }

    @Composable
    private fun MainContent() {
        Column {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Магазин ШЕСТЕРОЧКА",
                fontSize = 20.sp,
                color = Color.Black
            )
        }
    }

    override fun sellProduct(product: Product, nalBeznal: NalBeznal) {
        when(nalBeznal){
            NalBeznal.Nal ->{
                GlobalScope.launch {
                    val curBalance =  db.databaseDao().getBalance()
                    db.databaseDao().deleteProduct(product)
                    db.databaseDao().updateBalance(curBalance.copy(cash = curBalance.cash + product.price))
                }
            }
            NalBeznal.Beznal -> {
                GlobalScope.launch {
                    val curBalance =  db.databaseDao().getBalance()
                    db.databaseDao().deleteProduct(product)
                    db.databaseDao().updateBalance(curBalance.copy(cashless = curBalance.cash + product.price))
                }
            }
        }
    }

    override fun rejectSell() {
        TODO("Not yet implemented")
    }

    override fun order(order: Order) {
        GlobalScope.launch {
            db.databaseDao().order(order)
        }
    }

    override fun approveOrder(order: Order) {
        GlobalScope.launch {
            val curBalance =  db.databaseDao().getBalance()
            db.databaseDao().deleteOrder(order)
            val product = db.databaseDao().getProduct(id = order.productId)
            if (curBalance.cash > 0 ){
                db.databaseDao().updateBalance(curBalance.copy(cash = curBalance.cash - product.price))
            } else if (curBalance.cashless > 0){
                db.databaseDao().updateBalance(curBalance.copy(cashless = curBalance.cash - product.price))
            }
        }
    }
}

@Composable
private fun AboutScreen() {

}


@Composable
private fun MainScreen(
    onClickSomewhere: (Screen) -> Unit,
    content: @Composable () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            DrawerHeader()
            DrawerBody(
                items = listOf(
                    MenuItem(
                        id = "home",
                        title = "Home",
                        contentDescription = "Go to home screen",
                        icon = Icons.Default.Home
                    ),
                    MenuItem(
                        id = "about",
                        title = "Кассир",
                        contentDescription = "Кассир",
                        icon = Icons.Default.Info
                    ),
                    MenuItem(
                        id = "dissertation",
                        title = "Бухгалтер",
                        contentDescription = "Бухгалтер",
                        icon = Icons.Default.Info
                    ),
                    MenuItem(
                        id = "plans",
                        title = "Складовщик",
                        contentDescription = "Складовщик",
                        icon = Icons.Default.Info
                    ),
                ),
                onItemClick = { menuItem ->
                    when (menuItem.id) {
                        "home" -> {
                            onClickSomewhere(Screen.Home)
                        }
                        "Кассир" -> {
                            onClickSomewhere(Screen.Cashier)
                        }
                        "Бухгалтер" -> {
                            onClickSomewhere(Screen.Accountant)
                        }
                        "Складовщик" -> {
                            onClickSomewhere(Screen.Storekeeper)
                        }
                    }
                }
            )
        }
    ) {
        content()
    }
}
