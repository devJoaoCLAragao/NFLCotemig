package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cotemig.nflcotemig.R
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        back_login.setOnClickListener {
            showLogin()
        }
    }

    fun showLogin() {
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}