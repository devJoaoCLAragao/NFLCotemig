package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.nflcotemig.R
import br.com.cotemig.nflcotemig.model.ListaTeams
import br.com.cotemig.nflcotemig.model.Teams
import br.com.cotemig.nflcotemig.service.RetrofitInitializer
import br.com.cotemig.nflcotemig.ui.adapters.TeamsAdapter
import kotlinx.android.synthetic.main.activity_teams.*
import retrofit2.Call
import retrofit2.Response

class TeamsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        getTeam()

    }

    fun getTeam(){

        var s = RetrofitInitializer().serviceListaTeam()

        var call = s.getTeam()

        call.enqueue(object : retrofit2.Callback<ListaTeams>{
            override fun onResponse(call: Call<ListaTeams>, response: Response<ListaTeams>) {

                response?.let {
                    if (response.code()==200){
                        response.body()?.let {
                            showTable(it.teams)
                            //Toast.makeText(this@TeamsActivity, "Show de Bola", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ListaTeams>, t: Throwable) {
                Toast.makeText(this@TeamsActivity, "Erro", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun showTable(teams: List<Teams>){

        teamsdesc.adapter = TeamsAdapter(this, teams)
        teamsdesc.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}