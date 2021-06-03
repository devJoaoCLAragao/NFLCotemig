package br.com.cotemig.nflcotemig.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.nflcotemig.R
import br.com.cotemig.nflcotemig.model.Standings
import kotlinx.android.synthetic.main.item_header.view.*
import kotlinx.android.synthetic.main.item_table.view.*
import kotlinx.android.synthetic.main.item_table.view.divisionRank
import kotlinx.android.synthetic.main.item_table.view.losses
import kotlinx.android.synthetic.main.item_table.view.percentage
import kotlinx.android.synthetic.main.item_table.view.pointsAgainst
import kotlinx.android.synthetic.main.item_table.view.pointsFor
import kotlinx.android.synthetic.main.item_table.view.teamName
import kotlinx.android.synthetic.main.item_table.view.ties
import kotlinx.android.synthetic.main.item_table.view.wins

class TableAdapter (var context: Context, var table: List<Standings>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            var view = LayoutInflater.from(context).inflate(R.layout.item_header, parent, false)
            return HeaderHolder(view)
        } else {
            var view = LayoutInflater.from(context).inflate(R.layout.item_table, parent, false)
            return StandingsHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0 || position % 4 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0 || position % 4 == 0) {
            (holder as HeaderHolder).bind(table[position])
        }else {
            (holder as StandingsHolder).bind(table[position])
        }
    }

    override fun getItemCount(): Int {
        return table.size
    }

    class StandingsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(standings: Standings){

            itemView.teamName.text = standings.Name
            itemView.divisionRank.text = standings.DivisionRank.toString()
            itemView.wins.text = standings.Wins.toString()
            itemView.losses.text = standings.Losses.toString()
            itemView.ties.text = standings.Ties.toString()
            itemView.percentage.text = String.format("%.3f",standings.Percentage.toString().toDouble())
            itemView.pointsFor.text = standings.PointsFor.toString()
            itemView.pointsAgainst.text = standings.PointsAgainst.toString()
        }

    }


    class HeaderHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(standings: Standings){

            itemView.conference.text = standings.Conference+" "+standings.Division

            itemView.teamName.text = standings.Name
            itemView.divisionRank.text = standings.DivisionRank.toString()
            itemView.wins.text = standings.Wins.toString()
            itemView.losses.text = standings.Losses.toString()
            itemView.ties.text = standings.Ties.toString()
            itemView.percentage.text = String.format("%.3f",standings.Percentage.toString().toDouble())
            itemView.pointsFor.text = standings.PointsFor.toString()
            itemView.pointsAgainst.text = standings.PointsAgainst.toString()
        }

    }

}