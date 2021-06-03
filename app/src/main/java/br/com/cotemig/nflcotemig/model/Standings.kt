package br.com.cotemig.nflcotemig.model

data class Standings (
    var Conference: String = "",
    var Division: String = "",
    var Name: String = "",
    var Wins: Int = 0,
    var Losses: Int = 0,
    var Ties: Int = 0,
    var Percentage: Double = 0.0,
    var PointsFor: Int = 0,
    var PointsAgainst: Int = 0,
    var DivisionRank: Int = 0
)