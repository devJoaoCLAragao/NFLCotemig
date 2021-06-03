package br.com.cotemig.nflcotemig.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder().
    baseUrl("https://api.fluo.work/v1/").
    addConverterFactory(GsonConverterFactory.create()).
    build()

    private val retrofitStandings = Retrofit.Builder()
        .baseUrl("https://api.sportsdata.io/v3/nfl/scores/json/Standings/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun accountService() : AccountService{
        return retrofit.create(AccountService::class.java)
    }

    fun serviceListaStandings(): StandingService {
        return retrofitStandings.create(StandingService::class.java)
    }

}