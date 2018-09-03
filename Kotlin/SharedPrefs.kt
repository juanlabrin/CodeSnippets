//Class for Shared preferences, I used that for set sessions in Android (Login and Logout)
package aliensoft.cl.codesnippets

import android.content.Context
import android.content.SharedPreferences

class SharedPrefs (context: Context){

    //String names for shared pref file and key / values pairs, sets in res/values/strings.xml
    private val sharedPrefName: String = context.getString(R.string.sharedPreferences)
    private val keyUsername: String = context.getString(R.string.username)
    private val keyUserId: String = context.getString(R.string.user_id)
    private val keyUserRole: String = context.getString(R.string.user_role)

    private val sharedPrefs: SharedPreferences = context.getSharedPreferences(
            sharedPrefName, 0)

    //Set vars and methods
    var username: String
        get() = sharedPrefs.getString(keyUsername, "")
        set(value) = sharedPrefs.edit().putString(keyUsername, value).apply()

    var userid: Int
        get() = sharedPrefs.getInt(keyUserId, 0)
        set(value) = sharedPrefs.edit().putInt(keyUserId, value).apply()

    var userrole: Int
        get() = sharedPrefs.getInt(keyUserRole, 0)
        set(value) = sharedPrefs.edit().putInt(keyUserRole, value).apply()

    //Functions for login and logout
    fun isLoggedIn(): Boolean {
        return sharedPrefs.getString(keyUsername, null) != null
    }

    fun logout() {
        sharedPrefs.edit().clear().apply()
    }

}