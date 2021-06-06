package br.com.cotemig.nflcotemig.service

import br.com.cotemig.nflcotemig.model.ListaTeams
import retrofit2.Call
import retrofit2.http.GET

interface TeamService {

    @GET("search_all_teams.php?l=NFL")
    fun getTeam() : Call<ListaTeams>

}