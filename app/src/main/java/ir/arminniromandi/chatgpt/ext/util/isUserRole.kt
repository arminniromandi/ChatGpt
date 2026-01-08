package ir.arminniromandi.chatgpt.ext.util

import ir.arminniromandi.chatgpt.model.ai.Role


fun Role.isUserRole() = this == Role.User

fun Boolean.setRole() :String = if (this) Role.User.value else Role.Assistant.value
