package ir.arminniromandi.chatgpt.customUi

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.R


@Composable
fun AlertDialogYesNo(
    dialogState: MutableState<Boolean>,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { dialogState.value = false },
        confirmButton = {
            Button(
                onClick = { onConfirm() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    "yes",
                    fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                    style = MaterialTheme.typography.labelLarge // Apply typography
                )
            }
        },
        title = {
            Text(
                "do you Want To delete !",

                fontFamily = FontFamily(Font(R.font.satoshi_bold)),
                style = MaterialTheme.typography.headlineSmall
            )
        },
        text = {
            Text(
                "Are you sure you want to delete this message from this chat?",
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                style = MaterialTheme.typography.bodyMedium
            )
        },
        dismissButton = {
            OutlinedButton(
                onClick = { dialogState.value = false },
                border = BorderStroke(2.dp , color = Color.White)
                ) {
                Text(
                    "no",
                    fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    )
}



