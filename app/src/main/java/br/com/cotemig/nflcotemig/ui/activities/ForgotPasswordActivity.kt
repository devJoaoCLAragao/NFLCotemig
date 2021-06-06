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

        //TODO
        // "Tem que fazer isso funcionar"
        // Só ta "funcionando" o que vem da CreateAccountActivity
        // testei pelo Postman e a API não retorna nada..

        // esse e-mail vem da Create Account, se conta já existe...
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
        var call = s.create(account)

        call.enqueue(object : Callback<Account>{

            override fun onResponse(call: Call<Account>, response: Response<Account>) {
                if (response.code() == 200){
                    Toast.makeText(this@ForgotPasswordActivity, "Deu bom", Toast.LENGTH_LONG).show()
                }

            }
            override fun onFailure(call: Call<Account>, t: Throwable) {
                Toast.makeText(this@ForgotPasswordActivity, "Deu ruim", Toast.LENGTH_LONG).show()
            }


        } )
    }

}