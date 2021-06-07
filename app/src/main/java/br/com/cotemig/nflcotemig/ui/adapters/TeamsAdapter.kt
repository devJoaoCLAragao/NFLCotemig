package br.com.cotemig.nflcotemig.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.nflcotemig.R
import br.com.cotemig.nflcotemig.model.Teams
import br.com.cotemig.nflcotemig.ui.activities.DescTeamsActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_teams.view.*

class TeamsAdapter(var context: Context, var table: List<Teams>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_teams, parent, false)
        return TeamsHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TeamsHolder).bind(context, table[position])
    }

    override fun getItemCount(): Int {
        return table.size
    }

    class TeamsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(context: Context, teams: Teams){

            Glide.with(context).load(teams.strTeamBanner).into(itemView.strTeamBanner)

            itemView.strTeamBanner.setOnClickListener {
                var intent = Intent(context, DescTeamsActivity::class.java)
                intent.putExtra("team", teams)
                context.startActivity(intent)
            }

        }

    }
}