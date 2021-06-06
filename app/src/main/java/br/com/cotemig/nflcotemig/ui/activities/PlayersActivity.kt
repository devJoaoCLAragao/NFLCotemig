package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.nflcotemig.R
import br.com.cotemig.nflcotemig.model.Player
import br.com.cotemig.nflcotemig.model.Teams
import br.com.cotemig.nflcotemig.service.RetrofitInitializer
import br.com.cotemig.nflcotemig.ui.adapters.PlayersAdapter
import kotlinx.android.synthetic.main.activity_players.*
import retrofit2.Call
import retrofit2.Response

class PlayersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)

        getPlayer()
    }

    fun getPlayer() {
        var team = intent.getSerializableExtra("team") as Teams
        var s = RetrofitInitializer().serviceListaPlayers()
        var call = s.getPlayer(team.strTeamShort)
        call.enqueue(object : retrofit2.Callback<List<Player>> {
            override fun onResponse(call: Call<List<Player>>?,response: Response<List<Player>>?){

                response?.let {
                    if (it.code() == 200) {
                        response.body()?.let {
                            showTable(it)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Player>>?, t: Throwable?) {
                Toast.makeText(this@PlayersActivity, "Erro", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun showTable(players: List<Player>) {
        recyclerViewPlayers.adapter = PlayersAdapter(this, players)
        recyclerViewPlayers.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}