package br.com.cotemig.nflcotemig.service

import br.com.cotemig.nflcotemig.model.Player
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayerService {
    @GET("{user}?key=0d7369d8f1374febaa309f7e2b8f6532")
    fun getPlayer(@Path("user") user: String) : Call<List<Player>>
}