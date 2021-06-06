package br.com.cotemig.nflcotemig.model

import java.io.Serializable

data class Player (
    var Team : String = "",
    var Name : String = "",
    var Age : String = "",
    var PhotoUrl : String = "",
    var PositionCategory : String = "",
    var Position : String = ""

) : Serializable