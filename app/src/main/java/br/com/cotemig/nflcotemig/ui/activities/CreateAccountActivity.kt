package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.cotemig.nflcotemig.R
import br.com.cotemig.nflcotemig.model.Account
import br.com.cotemig.nflcotemig.service.RetrofitInitializer
import com.afollestad.materialdialogs.MaterialDialog
import kotlinx.android.synthetic.main.activity_create_account.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        back_login.setOnClickListener {
            showLogin()
        }

        btnCreateAccount.setOnClickListener {
            createAccount()
        }
    }

    fun showLogin(){
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun showForgotPassword(){
        var intent = Intent(this, ForgotPasswordActivity::class.java)
        intent.putExtra("email", create_email.text.toString())
        startActivity(intent)
        finish()
    }



    fun createAccount(){
        var account = Account()
        account.name = create_name.text.toString()
        account.email = create_email.text.toString()
        account.password = create_password.text.toString()

        var s = RetrofitInitializer().accountService()
        var call = s.create(account)

        call.enqueue(object : Callback<Account>{

            override fun onResponse(call: Call<Account>, response: Response<Account>) {
                if (response.code() == 200){
                   MaterialDialog(this@CreateAccountActivity).show {
                       title(R.string.usuario_criado_com_sucesso)
                       message(R.string.login_now)
                       positiveButton(R.string.ok){dialog ->
                           showLogin()
                       }

                   }
                } else if (response.code() == 409){
                    MaterialDialog(this@CreateAccountActivity).show {
                        title(R.string.ops)
                        message(R.string.user_reset_message)
                        positiveButton(R.string.yes) { dialog ->
                            showForgotPassword()
                        }
                        negativeButton(R.string.no)
                    }
                }
            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
                MaterialDialog(this@CreateAccountActivity).show {
                    title(R.string.ops)
                    message(R.string.internet_required)
                    positiveButton(R.string.ok)
                }
            }
        })
    }
}