package com.example.travelguide

import java.io.Serializable

data class Country(
    val id: Int,
    val name: String,
    val flagRes: Int,
    val continent: String,
    val continentEmoji: String,
    val capital: String,
    val currency: String,
    val language: String,
    val bestSeason: String,
    val budgetLevel: Int // 1=budget, 2=moderate, 3=expensive
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
