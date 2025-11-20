package ir.arminniromandi.chatgpt.ui.explore.gymplanner.componnent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun GetInfo() {

    val weight = remember { mutableStateOf("") }
    val age = remember { mutableStateOf("") }
    val height = remember { mutableStateOf("") }
    val days = remember { mutableStateOf("") }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextFieldForInfo(modifier = Modifier.weight(0.5f), weight, "weight")
        TextFieldForInfo(modifier = Modifier.weight(0.5f), age, "age")
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextFieldForInfo(modifier = Modifier.weight(0.5f), height, "height")
        TextFieldForInfo(modifier = Modifier.weight(0.5f), days, "count of days")
    }






}

@Composable
private fun TextFieldForInfo(
    modifier: Modifier,
    text: MutableState<String>,
    label: String
) {

    TextField(
        value = text.value,
        onValueChange = { text.value = it },
        label = { label },
        modifier = modifier
    )
}
