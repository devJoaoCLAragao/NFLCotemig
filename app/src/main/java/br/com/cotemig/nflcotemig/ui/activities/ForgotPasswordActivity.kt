package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cotemig.nflcotemig.R
import br.com.cotemig.nflcotemig.model.Account
import br.com.cotemig.nflcotemig.service.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_forgot_password.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        // esse e-mail vem da Create Account
        var email = Intent().getStringExtra("email")
        forgot_email.setText(email)

        btnForgotPassword.setOnClickListener {
            forgot()
        }
    }

    fun forgot(){
        var account = Account()
        account.email = forgot_email.text.toString()
        var s = RetrofitInitializer().accountService()
        var call = s.forgot(account)

        call.enqueue(object : Callback<Void>{
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@ForgotPasswordActivity, "DEU RUIM CORRE", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(this@ForgotPasswordActivity, "Email enviado", Toast.LENGTH_LONG).show()
            }
        } )
    }

}