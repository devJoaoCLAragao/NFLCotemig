package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import br.com.cotemig.nflcotemig.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val handle = Handler()
        handle.postDelayed({ showLogin() }, 3000)

    }

    fun showLogin(){
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}