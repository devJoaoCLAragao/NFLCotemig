package br.com.cotemig.nflcotemig.service

import br.com.cotemig.nflcotemig.model.ListaTeams
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlayerService {
    @GET("{team}")
    fun getTeam(@Query("team")team: String) : Call<ListaTeams>
}