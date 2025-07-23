package ir.arminniromandi.chatgpt.customUi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.ui.theme.Typography
import ir.arminniromandi.chatgpt.ui.theme.black

@Preview(showBackground = false, device = "id:pixel_5", showSystemUi = false)
@Composable
private fun krbdsrgfdsf() {

    val r = remember {
        mutableStateOf(true)
    }
AlertDialogYesNo(r) { }

}

@Composable
fun AlertDialogYesNo(
    dialogState: MutableState<Boolean>,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { dialogState.value = false },
        modifier = Modifier.padding(0.dp),
        confirmButton = {
            Button(
                onClick = { onConfirm() },

                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    "yes",
                    modifier = Modifier.padding(2.dp),
                    fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                    style = MaterialTheme.typography.labelLarge.copy(color = black) // Apply typography
                )
            }
        },
        title = {
            Text(
                "do you Want To delete!",
                fontFamily = FontFamily(Font(R.font.satoshi_bold)),
                style = MaterialTheme.typography.headlineSmall
            )
        },
        text = {
            Text(
                "Are you sure you want to delete this message from this chat?",
                style = Typography.bodyMedium
            )
        },
        dismissButton = {
            OutlinedButton(
                onClick = { dialogState.value = false },

                border = BorderStroke(2.dp , color = Color.White)
                ) {
                Text(
                    "no",
                    modifier = Modifier.padding(2.dp),
                    fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    )
}



