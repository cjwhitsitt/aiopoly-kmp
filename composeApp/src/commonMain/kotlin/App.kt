import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
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
    MaterialTheme {
        Scaffold(
            topBar = { TopAppBar(
                title = { Text("AIopoly") }
            ) }
        ) { innerPadding ->
            NavHost(
                navController = rememberNavController(),
                startDestination = "home",
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
            ) {
                composable(Screen.Home.name) { HomeScreen() }
            }
        }
    }
}