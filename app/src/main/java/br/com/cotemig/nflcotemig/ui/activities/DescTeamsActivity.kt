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

        var team = intent.getSerializableExtra("team") as Teams

        showDescTeams(team)

        strYoutube.setOnClickListener {
            openYoutube(team.strYoutube)
        }

        backTeamList.setOnClickListener {
            showTeamList()
        }

        buttonPlayer.setOnClickListener {
            showPlayers(team)
        }
    }


    fun showDescTeams(details: Teams) {
        Glide.with(this@DescTeamsActivity).load(details.strTeamBadge).into(strTeamBadge)
        Glide.with(this@DescTeamsActivity).load(details.strStadiumThumb).into(strStadiumThumb)
        strTeam.text = details.strTeam
        strManager.text = details.strManager
        strStadium.text = details.strStadium
        strStadiumLocation.text = details.strStadiumLocation
        intStadiumCapacity.text = details.intStadiumCapacity
    }

    fun openYoutube(url: String) {
        var intent = Intent(Intent.ACTION_VIEW)
        intent.setPackage("com.google.android.youtube")
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    fun showTeamList(){
        var intent = Intent(this, TeamsActivity::class.java)
        startActivity(intent)
    }

    //Pra abrir players aqui em baixo.
    fun showPlayers(details: Teams){
        var intent = Intent(this, PlayersActivity::class.java)
        intent.putExtra("team", details)
        startActivity(intent)
    }
}