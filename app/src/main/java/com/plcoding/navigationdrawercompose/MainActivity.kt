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
import com.plcoding.navigationdrawercompose.ui.theme.NavigationDrawerComposeTheme
import kotlinx.coroutines.launch


enum class Screen {
    Home,
    About,
    Dissertation,
    Plans
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var curScreen by rememberSaveable {
                mutableStateOf(Screen.Home)
            }
            BackHandler() {
                curScreen = Screen.Home
            }
            NavigationDrawerComposeTheme {
                MainScreen(
                    onClickSomewhere = {
                        curScreen = it
                    },
                    content = {
                        when (curScreen) {
                            Screen.Home -> MainContent()
                            Screen.About -> AboutContent()
                            Screen.Dissertation -> DissertationContent()
                            Screen.Plans -> PlansContent()
                        }
                    }
                )
            }
        }
    }

    @Composable
    private fun AboutContent(){
        Column() {
            Text("Интересный факт обо мне - я люблю повторяться. Я студент 4 курса, прикладной математики. Учусь в УрФУ, на матмехе.\n" +
                    "    Занимаюсь андроид разработкой. Работаю в Контуре, уже полтора года. В гугл особо не стремлюсь, мне и здесь хорошо\n" +
                    "    Курс конечно отличный, но как мне кажется, во многом устарел. Как минимум вся современная андроид разработка пишет на котлине :)" )
            Image(painterResource(id = R.drawable.cow), modifier = Modifier.fillMaxSize(),contentDescription = null)
        }
    }

    @Composable
    private fun DissertationContent(){
        Column() {
            Text("Я пока не написал диссертацию, и не очень хочу. Я даже толком не знаю что это такое, но могу рассказать анекдот." +
                    "\nБог прокрастинации обрушил на землю великий потом.")
            Image(painterResource(id = R.drawable.babka), modifier = Modifier.fillMaxSize(), contentDescription = null)
        }
    }

    @Composable
    private fun PlansContent(){
        Column() {
            Text(text = "Закончить универ")
            Text(text = "Выйти на фуллтайм на работу")
            Text(text = "Начать зарабатывать 300к/наносек")
            Text(text = "Профит")
            Image(painterResource(id = R.drawable.pepe),modifier = Modifier.fillMaxSize(), contentDescription = null)
        }
    }

    @Composable
    private fun MainContent() {
        Column {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = "Романов Александр Васильевич",
                fontSize = 20.sp,
                color = Color.Black
            )
            Image(
                painter = painterResource(id = R.drawable.me),
                alignment = Alignment.TopCenter,
                contentDescription = null
            )
            Text(
                text = """Я студент 4 курса, прикладной математики. Учусь в УрФУ, на матмехе.
    Занимаюсь андроид разработкой. Работаю в Контуре, уже полтора года. В гугл особо не стремлюсь, мне и здесь хорошо
    Курс конечно отличный, но как мне кажется, во многом устарел. Как минимум вся современная андроид разработка пишет на котлине :)""".trimMargin()
            )
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
                        title = "Обо мне",
                        contentDescription = "Обо мне",
                        icon = Icons.Default.Info
                    ),
                    MenuItem(
                        id = "dissertation",
                        title = "Моя диссертация",
                        contentDescription = "Моя диссертация",
                        icon = Icons.Default.Info
                    ),
                    MenuItem(
                        id = "plans",
                        title = "Мои планы",
                        contentDescription = "Мои планы",
                        icon = Icons.Default.Info
                    ),
                ),
                onItemClick = { menuItem ->
                    when (menuItem.id) {
                        "home" -> {
                            onClickSomewhere(Screen.Home)
                        }
                        "about" -> {
                            onClickSomewhere(Screen.About)
                        }
                        "dissertation" -> {
                            onClickSomewhere(Screen.Dissertation)
                        }
                        "plans" -> {
                            onClickSomewhere(Screen.Plans)
                        }
                    }
                }
            )
        }
    ) {
        content()
    }
}
