package br.com.cotemig.nflcotemig.service

import br.com.cotemig.nflcotemig.model.Account
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountService {
    @POST("account")
    fun create(@Body account: Account): Call<Account>

    @POST("account/forgot")
    fun forgot(@Body account: Account): Call<Void>

    @POST("account/auth")
    fun auth(@Body account: Account): Call<Account>
}