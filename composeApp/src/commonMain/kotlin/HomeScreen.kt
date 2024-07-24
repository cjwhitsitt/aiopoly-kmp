import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun HomeScreen(
    promptValue: String = "",
    onPromptChange: (String) -> Unit = {},
    onGenerateClick: () -> Unit = {}
) {
    val paddings = 16.dp

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(2f))
        Text(
            "Enter a theme for your game",
            modifier = Modifier.padding(paddings)
        )
        TextField(
            value = promptValue,
            onValueChange = onPromptChange,
            modifier = Modifier.padding(horizontal = paddings)
        )
        Button(
            onClick = onGenerateClick,
            modifier = Modifier.padding(paddings)
        ) {
            Text("Generate")
        }
        Spacer(Modifier.weight(2f))
    }
}