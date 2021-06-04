package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cotemig.nflcotemig.R
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.activity_standings.*

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        tableStanding.setOnClickListener {
            showStandings()
        }

        table15.setOnClickListener {
            showLastGames()
        }
    }

    fun showStandings(){
        var intent = Intent(this, StandingsActivity::class.java)
        startActivity(intent)
    }

    fun showLastGames(){
        var intent = Intent(this, LastGamesActivity::class.java)
        startActivity(intent)
    }

}