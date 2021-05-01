package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cotemig.nflcotemig.R
import br.com.cotemig.nflcotemig.model.Account
import br.com.cotemig.nflcotemig.service.RetrofitInitializer
import com.afollestad.materialdialogs.MaterialDialog
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        btnEnter.setOnClickListener {
            login()
        }
    }

    fun login(){
        var account = Account()
        account.email = login_email.text.toString()
        account.password = login_password.text.toString()
        var s = RetrofitInitializer().accountService()
        var call = s.auth(account)

        call.enqueue(object : Callback<Account>{

            override fun onResponse(call: Call<Account>, response: Response<Account>) {
                if (response.code() == 200){
                    showMainMenu()
                } else if (response.code() == 403) {
                    MaterialDialog(this@LoginActivity).show {
                        title(R.string.ops)
                        message(R.string.user_not_found)
                        positiveButton(R.string.yes) { dialog ->
                            showCreateAccount()
                        }
                        negativeButton(R.string.no)
                    }
                }
            }


            override fun onFailure(call: Call<Account>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


    fun showForgotPassword(){
        var intent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }

    fun showCreateAccount(){
        var intent = Intent(this, CreateAccountActivity::class.java)
        startActivity(intent)
    }

    fun showMainMenu(){
        var intent = Intent(this, MainMenuActivity::class.java)
        startActivity(intent)
        finish()
    }



}