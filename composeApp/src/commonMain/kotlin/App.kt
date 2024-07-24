import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class Screen {
    Home,
    Game
}

@Preview
@Composable
fun App() {
    val navController = rememberNavController()
    var promptValue by remember { mutableStateOf("") }

    MaterialTheme {
        Scaffold(
            topBar = { TopAppBar(
                title = { Text("AIopoly") }
            ) }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Home.name,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
            ) {
                composable(Screen.Home.name) { HomeScreen(
                    promptValue = promptValue,
                    onPromptChange = { promptValue = it },
                    onGenerateClick = {
                        navController.navigate(Screen.Game.name)
                    }
                ) }
                composable(Screen.Game.name) { GameScreen(
                    promptValue = promptValue
                ) }
            }
        }
    }
}