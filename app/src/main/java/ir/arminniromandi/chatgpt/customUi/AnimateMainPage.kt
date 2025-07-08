package ir.arminniromandi.chatgpt.customUi

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

@Composable
fun AnimateMainPage(
    density: Density,
    visible: Boolean,
    animateRun : MutableState<Boolean>,
     content: @Composable () -> Unit
) {

    Log.i("test", "AnimateMainPage: $visible")

    AnimatedVisibility(

        visible = visible,
        enter = slideInHorizontally(
            initialOffsetX = { with(density) { 40.dp.roundToPx() } },
            animationSpec = tween(
                durationMillis = 600,
                easing = FastOutSlowInEasing
            )
        ) + fadeIn(
            animationSpec = tween(
                durationMillis = 600,
                easing = FastOutSlowInEasing
            )
        ),
        modifier = Modifier.onGloballyPositioned {
            animateRun.value = false
        }

    ) { content() }

}