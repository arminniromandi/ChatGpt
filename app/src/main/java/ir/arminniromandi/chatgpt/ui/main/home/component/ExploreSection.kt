package ir.arminniromandi.chatgpt.ui.main.home.component

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.customUi.AnimateMainPage
import ir.arminniromandi.chatgpt.ext.util.SampleData
import ir.arminniromandi.chatgpt.model.ExploreCardItem
import ir.arminniromandi.chatgpt.navigation.screens.MainScreens
import ir.arminniromandi.chatgpt.ui.theme.Typography
import ir.arminniromandi.chatgpt.ui.theme.gray_300
import ir.arminniromandi.chatgpt.ui.theme.gray_700
import ir.arminniromandi.chatgpt.ui.theme.white
import ir.arminniromandi.chatgpt.ui.theme.whiteGradient
import ir.arminniromandi.myapplication.Tool.Constance.FloatingActionButtonModifier

@Composable
fun ExploreSection(visible: MutableState<Boolean>, expClick: (route : String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Explore More",
            color = white,
            style = Typography.headlineSmall
        )

        FloatingActionButton(
            { expClick(MainScreens.Explore.screenName) },
            containerColor = white,
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

    Spacer(Modifier.height(2.dp))

    val listState = rememberLazyListState()


    var animateRun = remember {
        mutableStateOf(false)
    }

    AnimateMainPage(visible = visible.value, animateRun = animateRun) {

        LazyRow(
            state = listState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
        ) {
            itemsIndexed(
                SampleData.items,
                key = { _, item -> item.title }
            ) { index, item ->

                ExploreItemCard(
                    item = item,
                    listState = listState
                )
            }

        }

    }


}

@Composable
private fun ExploreItemCard(
    item: ExploreCardItem,
    listState: LazyListState
) {
    // انیمیشن برای scale و elevation در حین اسکرول
    val interactionSource = remember { MutableInteractionSource() }
    var isPressed by remember { mutableStateOf(false) }


    // انیمیشن scale برای حالت فشردن
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "scale_animation"
    )





    Card(
        modifier = Modifier
            .width(210.dp)
            .height(158.dp)
            .scale(scale)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                role = androidx.compose.ui.semantics.Role.Button
            ) {
                
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                    }
                )
            },
        shape = RoundedCornerShape(38.dp),
        colors = CardDefaults.cardColors(containerColor = gray_700)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.5.dp,
                    brush = Brush.verticalGradient(
                        colors = whiteGradient
                    ),
                    shape = RoundedCornerShape(38.dp)
                )
                .padding(12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxSize()
            ) {
                // انیمیشن آیکون
                val iconScale by animateFloatAsState(
                    targetValue = if (isPressed) 1.1f else 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessHigh
                    ),
                    label = "icon_scale"
                )

                Icon(
                    painter = painterResource(item.icon),
                    modifier = Modifier
                        .size(28.dp)
                        .scale(iconScale),
                    tint = white,
                    contentDescription = ""
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = item.title,
                    style = Typography.titleLarge,
                    color = white
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = item.des,
                    style = Typography.titleMedium.copy(color = gray_300)
                )
            }
        }
    }
}

