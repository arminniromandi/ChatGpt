package ir.arminniromandi.chatgpt.Tool.util

import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.model.ExploreCardItem
import ir.arminniromandi.chatgpt.ui.explore.ExploreScreens

object ExploreData {

    val items = listOf(
        ExploreCardItem(
            "Writing",
            R.drawable.pen_writing,
            "Writing a story or text for article or interview",
            ExploreScreens.Writing.screenName
        ),
        ExploreCardItem(
            "Code Generation",
            R.drawable.pen_writing,
            "Create code quickly with any programming language",
            ExploreScreens.Code.screenName
        )

    )


}