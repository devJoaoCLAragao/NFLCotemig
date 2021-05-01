package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cotemig.nflcotemig.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        forgot_password.setOnClickListener {
            showForgotPassword()
        }

        create_account.setOnClickListener {
            showCreateAccount()
        }
    }

    fun showForgotPassword(){
        var intent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }

    fun showCreateAccount(){
        var intent = Intent(this, CreateAccountActivity::class.java)
        startActivity(intent)
    }

}