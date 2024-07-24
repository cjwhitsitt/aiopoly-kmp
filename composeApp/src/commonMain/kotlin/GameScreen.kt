import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.Group
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import network.Api
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun GameScreen(
    promptValue: String = ""
) {
    var groups by remember { mutableStateOf(emptyList<Group>()) }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Prompt = $promptValue")
        Spacer(Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator()
        } else {
            groups.forEach { group ->
                Text("Color: ${group.color} (${group.hex})")
                group.properties.forEach { property ->
                    Text(property.name)
                }
                Spacer(Modifier.height(16.dp))
            }
        }
    }

    LaunchedEffect(promptValue) {
        isLoading = true
        groups = Api.instance.generateProperties(promptValue).result.groups
        isLoading = false
    }
}