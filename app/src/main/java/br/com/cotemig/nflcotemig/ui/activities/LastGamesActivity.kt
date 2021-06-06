package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.nflcotemig.R
import br.com.cotemig.nflcotemig.model.LastGames
import br.com.cotemig.nflcotemig.model.ListaLastGames
import br.com.cotemig.nflcotemig.service.RetrofitInitializer
import br.com.cotemig.nflcotemig.ui.adapters.LastGamesAdapter
import kotlinx.android.synthetic.main.activity_lastgames.*
import retrofit2.Call
import retrofit2.Response

class LastGamesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lastgames)

        getLastGames()

        backMainMenu2.setOnClickListener {
            backMenu()
        }

        youtubetest.setOnClickListener {
            openYoutube("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
        }

    }

    fun getLastGames() {

        var s = RetrofitInitializer().serviceLastGames()

        var call = s.getLastGames()

        call.enqueue(object : retrofit2.Callback<ListaLastGames> {
            override fun onResponse(
                call: Call<ListaLastGames>,
                response: Response<ListaLastGames>
            ) {

                response?.let {
                    if (response.code() == 200) {
                        response.body()?.let {
                            showLastGames(it.events)
                            //Toast.makeText(this@LastGamesActivity, "Show de Bola", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ListaLastGames>, t: Throwable) {
                Toast.makeText(this@LastGamesActivity, "erroStandings", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun showLastGames(list: List<LastGames>) {
        gamesList.adapter = LastGamesAdapter(this, list)
        gamesList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    fun backMenu() {
        var intent = Intent(this, MainMenuActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun openYoutube(url: String){
        var intent = Intent(Intent.ACTION_VIEW)
        intent.setPackage("com.google.android.youtube")
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}