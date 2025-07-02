package ir.arminniromandi.chatgpt.Tool.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(@ApplicationContext context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

    companion object {
        const val USER_NAME = "user_name"
        const val USER_PHONE = "user_phone"
    }

    fun saveUserName(userName: String) {
        sharedPreferences.edit {
            putString(USER_NAME, userName)
        }
    }

    fun saveUserPhone(userPhone: String) {
        sharedPreferences.edit {
            putString(USER_PHONE, userPhone)
        }
    }

    fun getUserName(): String? {
        return sharedPreferences.getString(USER_NAME, "")
    }

    fun getUserPhone(): String? {
        return sharedPreferences.getString(USER_PHONE, "Not Set")
    }


}