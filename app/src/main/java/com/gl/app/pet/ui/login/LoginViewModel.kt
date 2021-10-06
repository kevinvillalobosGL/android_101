package com.gl.app.pet.ui.login

import androidx.lifecycle.ViewModel
import com.gl.app.pet.data.db.UserDB

/**
 * @author Kevin Villalobos
 * @since 10/5/21
 */
class LoginViewModel : ViewModel() {

    fun doLogin(email:String, password:String) : Boolean {
        return email.isNotEmpty() && password.isNotEmpty() && email == UserDB.USER_EMAIL
    }

}