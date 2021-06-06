package br.com.cotemig.nflcotemig.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.nflcotemig.R
import br.com.cotemig.nflcotemig.model.Player

class PlayersAdapter (var context: Context, var list : List<Player>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_players, parent, false)
        return PlayerHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PlayerHolder).bind(context, list[position])
    }

    class PlayerHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bind(context : Context, player : Player){

        }
    }
}