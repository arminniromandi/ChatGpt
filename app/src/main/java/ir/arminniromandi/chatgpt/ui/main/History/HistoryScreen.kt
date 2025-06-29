package ir.arminniromandi.chatgpt.ui.main.History

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.arminniromandi.chatgpt.ui.main.History.component.HistoryHeader
import ir.arminniromandi.chatgpt.ui.main.History.component.HistorySection
import ir.arminniromandi.chatgpt.ui.theme.background2
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel

@Composable
fun HistoryScreen(viewModel: MainViewModel = hiltViewModel()) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .background(background2),

        ) {


        HistoryHeader()

        HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp))

        HistorySection()



    }

}

@Preview
@Composable
private fun dfsfgsr() {
    HistoryHeader()
}
