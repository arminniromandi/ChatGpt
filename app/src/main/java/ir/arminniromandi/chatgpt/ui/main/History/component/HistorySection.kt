package ir.arminniromandi.chatgpt.ui.main.History.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.ui.theme.gray_300
import ir.arminniromandi.chatgpt.ui.theme.white

@Composable
fun  HistorySection(){

    LazyColumn(){
        items(10){
            HistoryItem("Title","this is text and no meaning")
        }

    }

}
@Composable
private fun HistoryItem(title: String, text: String) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            title,
            color = white,
            fontFamily = FontFamily(Font(R.font.satoshi_medium)),
            fontSize = 16.sp
        )

        Text(
            text,
            color = gray_300,
            fontFamily = FontFamily(Font(R.font.satoshi_medium)),
            fontSize = 15.sp
        )

    }
}