import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun App() {
    var promptValue by remember { mutableStateOf("") }
    val paddings = 16.dp

    MaterialTheme {
        Scaffold(
            topBar = { TopAppBar(
                title = { Text("AIopoly") }
            ) }
        ) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.weight(2f))
                Text(
                    "Enter a theme for your game",
                    modifier = Modifier.padding(paddings)
                )
                TextField(
                    value = promptValue,
                    onValueChange = { promptValue = it },
                    modifier = Modifier.padding(horizontal = paddings)
                )
                Button(
                    onClick = {
                        // TODO: generate game
                    },
                    modifier = Modifier.padding(paddings)
                ) {
                    Text("Generate")
                }
                Spacer(Modifier.weight(2f))
            }
        }
    }
}