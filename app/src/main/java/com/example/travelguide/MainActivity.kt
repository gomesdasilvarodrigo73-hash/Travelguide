package com.example.travelguide

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar Toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = "🌍 Dicas de Viagem"

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        
        val countries = getCountries()
        val adapter = CountryAdapter(this, countries)
        
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun logout() {
        // Limpar sessão
        val sharedPreferences = getSharedPreferences("UserSession", Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()
        
        // Redirecionar para LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
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
            ),
            Country(
                id = 4,
                name = "Brasil",
                flagRes = R.drawable.flag_brasil,
                continent = "América do Sul",
                capital = "Brasília",
                currency = "BRL",
                language = "Português"
            ),
            Country(
                id = 5,
                name = "Itália",
                flagRes = R.drawable.flag_italia,
                continent = "Europa",
                capital = "Roma",
                currency = "EUR",
                language = "Italiano"
            ),
            Country(
                id = 6,
                name = "Reino Unido",
                flagRes = R.drawable.flag_uk,
                continent = "Europa",
                capital = "Londres",
                currency = "GBP",
                language = "Inglês"
            ),
            Country(
                id = 7,
                name = "Estados Unidos",
                flagRes = R.drawable.flag_usa,
                continent = "América do Norte",
                capital = "Washington D.C.",
                currency = "USD",
                language = "Inglês"
            ),
            Country(
                id = 8,
                name = "Japão",
                flagRes = R.drawable.flag_japao,
                continent = "Ásia",
                capital = "Tóquio",
                currency = "JPY",
                language = "Japonês"
            )
        )
    }
}
