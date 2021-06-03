package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cotemig.nflcotemig.R
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        tableStanding.setOnClickListener {
            showStandings()
        }

    }

    fun showStandings(){
        var intent = Intent(this, StandingsActivity::class.java)
        startActivity(intent)
        finish()
    }

}