package com.example.travelguide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        
        val countries = getCountries()
        val adapter = CountryAdapter(this, countries)
        
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun getCountries(): List<Country> {
        return listOf(
            Country(
                id = 1,
                name = "Portugal",
                flagRes = R.drawable.flag_portugal,
                continent = "Europa",
                capital = "Lisboa",
                currency = "EUR",
                language = "Português"
            ),
            Country(
                id = 2,
                name = "Espanha",
                flagRes = R.drawable.flag_espanha,
                continent = "Europa",
                capital = "Madrid",
                currency = "EUR",
                language = "Espanhol"
            ),
            Country(
                id = 3,
                name = "França",
                flagRes = R.drawable.flag_franca,
                continent = "Europa",
                capital = "Paris",
                currency = "EUR",
                language = "Francês"
            )
        )
    }
}
