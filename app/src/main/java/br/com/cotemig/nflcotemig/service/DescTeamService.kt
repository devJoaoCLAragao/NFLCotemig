package br.com.cotemig.nflcotemig.service

import br.com.cotemig.nflcotemig.model.ListaTeams
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DescTeamService {

    @GET("lookupteam.php?id={user}")
//    fun getDescTeam(@Path("user")user: String) : Call<ListaTeams>

    fun getDescTeam(@Query("user")user: String) : Call<ListaTeams>

}