package ir.arminniromandi.chatgpt.Fragment.ExplorePage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.background2
import ir.arminniromandi.chatgpt.customUi.topBar.TopBarExplore


@Composable
fun ExploreWriting (){

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        TopBarExplore()



    }



}

@Composable
private fun Body() {

    var text by remember {
        mutableStateOf("")
    }

    Column(Modifier.fillMaxSize()) {

        Row(Modifier.fillMaxWidth()) {


        }
        OutlinedTextField(


            value = text ,
            onValueChange = {
                text = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            label = {
                Text(text = "create Story About")
            }

        )

        Button(
            {},

        ) { }


    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BottomSheet (state : MutableState<Boolean>) {


    // TODO: Complete Bottom Sheet
    if (state.value){
        ModalBottomSheet(
            onDismissRequest = {state.value = false},
            containerColor = background2

        ) {






        }
    }


}
