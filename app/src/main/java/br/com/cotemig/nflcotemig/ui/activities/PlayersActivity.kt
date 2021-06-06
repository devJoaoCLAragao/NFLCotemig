package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cotemig.nflcotemig.R
import kotlinx.android.synthetic.main.activity_players.*

class PlayersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)

        //botão voltar
        backDescTeams.setOnClickListener {
            showTeamDesc()
        }



    }

    //botão voltar
    fun showTeamDesc(){
        var intent = Intent(this, DescTeamsActivity::class.java)
        startActivity(intent)
        finish()
    }
}