package ir.arminniromandi.chatgpt.ui.home.component

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.Activity.PromptLibraryActivity
import ir.arminniromandi.chatgpt.Typography
import ir.arminniromandi.chatgpt.white
import ir.arminniromandi.chatgpt.whiteGradient
import ir.arminniromandi.myapplication.Tool.Constance.FloatingActionButtonModifier

@Composable
fun PromptSection(context : Context) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Prompt Library",
            style = Typography.headlineSmall,
            color = white
        )


        FloatingActionButton(
            {
                context.startActivity(Intent(context, PromptLibraryActivity::class.java))
            },
            elevation = FloatingActionButtonDefaults.elevation(10.dp),
            containerColor = Color.White,
            modifier = Modifier.size(52.dp),
            shape = CircleShape
        ) {
            Image(
                imageVector = Icons.AutoMirrored.Default.ArrowForward,
                modifier = FloatingActionButtonModifier,
                contentDescription = "Explore More"
            )
        }

    }

    val a = arrayOf("Seo", "Develope", "Marketing", "job", "Code")

    Spacer(Modifier.height(4.dp))

    LazyHorizontalStaggeredGrid(
        modifier = Modifier
            .fillMaxWidth()
            .height(125.dp),
        rows = StaggeredGridCells.Fixed(2),
        horizontalItemSpacing = 4.dp
    ) {
        items(a) {
            PromptChip(it)
        }
    }



}

@Composable
private fun PromptChip(text : String) {

    Row(
        modifier = Modifier
            .padding(vertical = 2.dp)
            .clip(CircleShape)
            .border(
                width = (1.5).dp,
                brush = Brush.horizontalGradient(whiteGradient),
                shape = CircleShape
            )
            .background(Color.Black)
            .padding(horizontal = 13.dp),

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text,
            style = Typography.labelMedium,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
            color = white
        )

    }


}