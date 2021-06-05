package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cotemig.nflcotemig.R
import br.com.cotemig.nflcotemig.model.ListaTeams
import br.com.cotemig.nflcotemig.model.Teams
import br.com.cotemig.nflcotemig.service.RetrofitInitializer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_descteams.*
import retrofit2.Call
import retrofit2.Response

class DescTeamsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descteams)

        getDescTeam()

    }

    fun getDescTeam(){

        var details = intent.getSerializableExtra("team") as Teams

        var s = RetrofitInitializer().serviceListaDescTeam()

        var call = s.getDescTeam(details.idTeam)

        call.enqueue(object : retrofit2.Callback<ListaTeams>{
            override fun onResponse(call: Call<ListaTeams>, response: Response<ListaTeams>) {

                response?.let {
                    if (response.code() == 200) {
                        response.body()?.let {
                            showDescTeams(details)
                            strYoutube.setOnClickListener {
                                openYoutube(details.strYoutube)
                            }
//                            buttonPlayer.setOnClickListener {
//                                openPlayers(details)
//                            }
                            //Toast.makeText(this@LastGamesActivity, "Show de Bola", Toast.LENGTH_LONG).show()
                        }
                    }
                }
                Toast.makeText(this@DescTeamsActivity, "Show de bola", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<ListaTeams>, t: Throwable) {
                Toast.makeText(this@DescTeamsActivity, "Erro", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun showDescTeams(details: Teams){
        Glide.with(this@DescTeamsActivity).load(details.strTeamBadge).into(strTeamBadge)
        strTeam.text = details.strTeam
        strManager.text = details.strManager
        strStadium.text = details.strStadium
        strStadiumLocation.text = details.strStadiumLocation
        intStadiumCapacity.text = details.intStadiumCapacity
    }

    fun openYoutube(url: String){
        var intent = Intent(Intent.ACTION_VIEW)

        intent.setPackage("com.google.android.youtube")
        intent.data = Uri.parse(url)

        startActivity(intent)
    }

//    fun openPlayers(details: Teams){
//        var intent = Intent(this, PlayersActivity::class.java)
//        intent.putExtra("team", details)
//        startActivity(intent)
//    }
}