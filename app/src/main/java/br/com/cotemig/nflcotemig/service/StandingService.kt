package br.com.cotemig.nflcotemig.service

import br.com.cotemig.nflcotemig.model.Standings
import retrofit2.Call
import retrofit2.http.GET

interface StandingService{

    @GET("2020?key=0d7369d8f1374febaa309f7e2b8f6532")
    fun getStanding() : Call<List<Standings>>

}