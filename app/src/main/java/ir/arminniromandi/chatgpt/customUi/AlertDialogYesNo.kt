package ir.arminniromandi.chatgpt.customUi

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import ir.arminniromandi.chatgpt.R


// TODO: make color perfect
@Composable
fun AlertDialogYesNo(
    dialogState: MutableState<Boolean>,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { dialogState.value = false },
        confirmButton = {
            Button(onClick = { onConfirm() }) {
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
            OutlinedButton(onClick = { dialogState.value = false }) {
                Text(
                    "no",
                    fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    )
}


@SuppressLint("UnrememberedMutableState")
@Preview(showSystemUi = true)
@Composable
private fun PreviewAlert() {


    Column (Modifier.fillMaxSize()){
        AlertDialogYesNo(mutableStateOf(true),
            {})
    }
}
