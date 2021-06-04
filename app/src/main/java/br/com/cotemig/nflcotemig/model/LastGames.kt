package br.com.cotemig.nflcotemig.model

import java.io.Serializable

data class LastGames (
    var strEvent: String = "",
    var strHomeTeam: String = "",
    var strAwayTeam: String = "",
    var intHomeScore: String = "",
    var intAwayScore: String = "",
    var dateEvent: String = "",
    var strTime: String = "",
    var strVideo: String = "",
    var idHomeTeam: String = "",
    var idAwayTeam: String = ""
): Serializable