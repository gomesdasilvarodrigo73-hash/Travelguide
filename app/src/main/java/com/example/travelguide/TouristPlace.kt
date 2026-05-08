package com.example.travelguide

import java.io.Serializable

data class TouristPlace(
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int,
    val location: String = "",
    val curiosities: String = ""
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
