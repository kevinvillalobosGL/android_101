package com.gl.app.pet.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.gl.app.pet.R
import com.gl.app.pet.ui.main.MainActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private val mViewModel: LoginViewModel = LoginViewModel()

    private lateinit var btnLogin: Button
    private lateinit var txtEmail: TextInputEditText
    private lateinit var txtPassword: TextInputEditText
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilPassword: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Get the Views
        btnLogin = findViewById(R.id.btn_login)
        txtEmail = findViewById(R.id.tix_email)
        txtPassword = findViewById(R.id.tix_password)
        tilEmail = findViewById(R.id.til_email)
        tilPassword = findViewById(R.id.til_password)

        // Click Listener
        btnLogin.setOnClickListener {
            val email = txtEmail.text.toString().trim()
            val password = txtPassword.text.toString().trim()
            val loginResult = mViewModel.doLogin(email, password)
            if (loginResult) {
                tilEmail.isErrorEnabled = false
                tilPassword.isErrorEnabled = false
                goToHome()
            } else {
                tilEmail.error = getString(R.string.error_login)
                tilPassword.error = getString(R.string.error_login)
            }
        }
    }

    /**
     * Go to Main Activity
     */
    private fun goToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}