package br.com.cotemig.nflcotemig.service

import br.com.cotemig.nflcotemig.model.ListaLastGames
import retrofit2.Call
import retrofit2.http.GET

interface LastGameService {

    @GET("eventspastleague.php?id=4391")
    fun getLastGames() : Call<ListaLastGames>

}