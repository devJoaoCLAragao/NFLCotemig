package br.com.cotemig.nflcotemig.ui.adapters

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.nflcotemig.R
import br.com.cotemig.nflcotemig.model.LastGames
import br.com.cotemig.nflcotemig.model.Teams
import br.com.cotemig.nflcotemig.ui.activities.LastGamesActivity
import kotlinx.android.synthetic.main.item_lastgames.view.*

class LastGamesAdapter(var context: Context, var listlg: List<LastGames>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_lastgames, parent, false)
        return LastGamesHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as LastGamesHolder).bind(context, listlg[position])
    }

    override fun getItemCount(): Int {
        return listlg.size
    }

    class LastGamesHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(context: Context, lastGames: LastGames){
            itemView.event.text = lastGames.strEvent
            itemView.dateEvent.text = lastGames.dateEvent
            itemView.timeEvent.text = lastGames.strTime
            itemView.homeTeam.text = lastGames.strHomeTeam
            itemView.awayTeam.text = lastGames.strAwayTeam
            itemView.homeScore.text = lastGames.intHomeScore
            itemView.awayScore.text = lastGames.intAwayScore

            itemView.video.setOnClickListener {
                openYoutubeLink(context, lastGames.strVideo)
            }

        }

        fun openYoutubeLink(context: Context, youtubeID: String) {
            val intentApp = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeID))
            val intentBrowser =
                Intent(Intent.ACTION_VIEW, Uri.parse(youtubeID))
            try {
                context.startActivity(intentApp)
            } catch (ex: ActivityNotFoundException) {
                context.startActivity(intentBrowser)
            }
        }
    }
}