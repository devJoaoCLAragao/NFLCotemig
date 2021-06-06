package br.com.cotemig.nflcotemig.ui.activities

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
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
            openYoutubeLink(team.strYoutube)
        }

        buttonPlayer.setOnClickListener {
            showPlayers(team)
        }

        strFacebook.setOnClickListener {
            startActivity(getOpenFacebookIntent(team.strFacebook))
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

    fun openYoutubeLink(youtubeID: String) {
        val intentApp = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + youtubeID))
        val intentBrowser =
            Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + youtubeID))
        try {
            startActivity(intentApp)
        } catch (ex: ActivityNotFoundException) {
            startActivity(intentBrowser)
        }
    }

    private fun getOpenFacebookIntent(url: String): Intent? {
        return try {
            packageManager.getPackageInfo("com.facebook.katana", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("http://$url"))
        } catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("http://$url"))
        }
    }


    //Pra abrir players aqui em baixo.
    fun showPlayers(details: Teams){
        var intent = Intent(this, PlayersActivity::class.java)
        intent.putExtra("team", details)
        startActivity(intent)
    }
}