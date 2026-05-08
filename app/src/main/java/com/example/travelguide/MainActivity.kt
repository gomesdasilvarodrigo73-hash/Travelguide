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
            // Europa
            Country(1, "Portugal", R.drawable.flag_portugal, "Europa", "Lisboa", "EUR", "Português"),
            Country(2, "Espanha", R.drawable.flag_espanha, "Europa", "Madrid", "EUR", "Espanhol"),
            Country(3, "França", R.drawable.flag_franca, "Europa", "Paris", "EUR", "Francês"),
            Country(4, "Itália", R.drawable.flag_italia, "Europa", "Roma", "EUR", "Italiano"),
            Country(5, "Alemanha", R.drawable.flag_alemanha, "Europa", "Berlim", "EUR", "Alemão"),
            Country(6, "Reino Unido", R.drawable.flag_uk, "Europa", "Londres", "GBP", "Inglês"),
            Country(7, "Suíça", R.drawable.flag_suica, "Europa", "Berna", "CHF", "Alemão/Francês/Italiano"),
            Country(8, "Países Baixos", R.drawable.flag_holanda, "Europa", "Amesterdão", "EUR", "Holandês"),
            Country(9, "Bélgica", R.drawable.flag_belgica, "Europa", "Bruxelas", "EUR", "Holandês/Francês"),
            Country(10, "Áustria", R.drawable.flag_austria, "Europa", "Viena", "EUR", "Alemão"),
            Country(11, "Grécia", R.drawable.flag_grecia, "Europa", "Atenas", "EUR", "Grego"),
            Country(12, "Polónia", R.drawable.flag_polonia, "Europa", "Varsóvia", "PLN", "Polaco"),
            
            // Américas
            Country(13, "Brasil", R.drawable.flag_brasil, "América do Sul", "Brasília", "BRL", "Português"),
            Country(14, "Estados Unidos", R.drawable.flag_usa, "América do Norte", "Washington D.C.", "USD", "Inglês"),
            Country(15, "Canadá", R.drawable.flag_canada, "América do Norte", "Ottawa", "CAD", "Inglês/Francês"),
            Country(16, "México", R.drawable.flag_mexico, "América do Norte", "Cidade do México", "MXN", "Espanhol"),
            Country(17, "Argentina", R.drawable.flag_argentina, "América do Sul", "Buenos Aires", "ARS", "Espanhol"),
            Country(18, "Chile", R.drawable.flag_chile, "América do Sul", "Santiago", "CLP", "Espanhol"),
            Country(19, "Colômbia", R.drawable.flag_colombia, "América do Sul", "Bogotá", "COP", "Espanhol"),
            Country(20, "Peru", R.drawable.flag_peru, "América do Sul", "Lima", "PEN", "Espanhol"),
            
            // Ásia
            Country(21, "Japão", R.drawable.flag_japao, "Ásia", "Tóquio", "JPY", "Japonês"),
            Country(22, "China", R.drawable.flag_china, "Ásia", "Pequim", "CNY", "Mandarim"),
            Country(23, "Coreia do Sul", R.drawable.flag_coreia, "Ásia", "Seul", "KRW", "Coreano"),
            Country(24, "Índia", R.drawable.flag_india, "Ásia", "Nova Délhi", "INR", "Hindi/Inglês"),
            Country(25, "Tailândia", R.drawable.flag_tailandia, "Ásia", "Bangkok", "THB", "Tailandês"),
            Country(26, "Singapura", R.drawable.flag_singapura, "Ásia", "Singapura", "SGD", "Inglês"),
            Country(27, "Emirados Árabes", R.drawable.flag_uae, "Ásia", "Abu Dhabi", "AED", "Árabe"),
            Country(28, "Turquia", R.drawable.flag_turquia, "Ásia/Europa", "Ancara", "TRY", "Turco"),
            
            // Oceania
            Country(29, "Austrália", R.drawable.flag_australia, "Oceania", "Canberra", "AUD", "Inglês"),
            Country(30, "Nova Zelândia", R.drawable.flag_nz, "Oceania", "Wellington", "NZD", "Inglês"),
            
            // África
            Country(31, "Egito", R.drawable.flag_egito, "África", "Cairo", "EGP", "Árabe"),
            Country(32, "Marrocos", R.drawable.flag_marrocos, "África", "Rabat", "MAD", "Árabe"),
            Country(33, "África do Sul", R.drawable.flag_south_africa, "África", "Pretória", "ZAR", "Inglês")
        )
    }
}
