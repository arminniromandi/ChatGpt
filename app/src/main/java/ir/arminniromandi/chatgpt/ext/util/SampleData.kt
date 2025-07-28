package ir.arminniromandi.chatgpt.ext.util

import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.model.ExploreCardItem
import ir.arminniromandi.chatgpt.model.PromptItem
import ir.arminniromandi.chatgpt.ui.explore.ExploreScreens



object SampleData {

    val items = listOf<ExploreCardItem>(
        ExploreCardItem(
            "Writing",
            R.drawable.pen_writing,
            "Writing a story or text for article or interview",

            ExploreScreens.Writing.screenName
        ),
        ExploreCardItem(
            "Gym Planner",
            R.drawable.pen_writing,
            "Create a personalized gym workout plan tailored.",
            ExploreScreens.GymPlanner.screenName
        )

    )

    val samplePromptLib = arrayOf(
        PromptItem(title = "Develop"),
        PromptItem(title = "Seo"),
        PromptItem(title = "Marketing"),
        PromptItem(title = "job"),
        PromptItem(title = "Code")
    )


}