package ir.arminniromandi.chatgpt.model.ai

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import ir.arminniromandi.chatgpt.R

@SuppressLint("SupportAnnotationUsage")

enum class AiModel(val value: String, val icon: Int) {
    @DrawableRes Gpt4Nano("gpt-4.1-nano",  R.drawable.chatgpt),
    @DrawableRes Gpt41Mini("gpt-4.1-mini", R.drawable.chatgpt),
    @DrawableRes Gem25Fl("gemini-2.5-flash-lite", R.drawable.gemini),
    @DrawableRes DeepSeekR1("deepseek-r1-0528", R.drawable.deepseek)

}