package com.example.travelguide

import java.io.Serializable

data class Country(
    val id: Int,
    val name: String,
    val flagRes: Int,
    val continent: String,
    val capital: String,
    val currency: String,
    val language: String
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
