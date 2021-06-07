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
            val facebookIntent = Intent(Intent.ACTION_VIEW)
            val facebookUrl = getFacebookPageURL(this, team.strFacebook)
            facebookIntent.data = Uri.parse(facebookUrl)
            startActivity(facebookIntent)
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

    fun getFacebookPageURL(context: Context, url: String): String? {

        var FACEBOOK_URL = "https://$url"
        var FACEBOOK_PAGE_ID = "YourPageName"

        val packageManager = context.packageManager
        return try {
            val versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode
            if (versionCode >= 3002850) { //newer versions of fb app
                "fb://facewebmodal/f?href=$FACEBOOK_URL"
            } else { //older versions of fb app
                "fb://page/$FACEBOOK_PAGE_ID"
            }
        } catch (e: PackageManager.NameNotFoundException) {
            FACEBOOK_URL //normal web url
        }
    }


    //Pra abrir players aqui em baixo.
    fun showPlayers(details: Teams){
        var intent = Intent(this, PlayersActivity::class.java)
        intent.putExtra("team", details)
        startActivity(intent)
    }
}