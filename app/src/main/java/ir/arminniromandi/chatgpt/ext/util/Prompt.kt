package ir.arminniromandi.chatgpt.ext.util

class Prompt {
    //get system lang from device
    val language: String = "English"
    fun gymPlannerP(
        goal: String,
        gender: String,
        height: String,
        weight: String,
        age: String,
        days: String,
        language: String,
        des: String
    )
    = "I want you to act as a professional fitness coach. Create a personalized workout plan for me based on the following details:"+
    "My fitness goal is $goal ."+
    "My current fitness level = Pro." +
    "The number of days $days per week I can train."+
    "The type of training I prefer gym." + des +
    "My age $age, weight $weight, and height $height , and gender $gender. "+
    "The workout plan should be detailed, including sets, reps, rest times, and progression over time. Also, give me recommendations for warm-ups, cool-downs, and recovery. Please make it motivating and practical." +
            "in language = $language"



}