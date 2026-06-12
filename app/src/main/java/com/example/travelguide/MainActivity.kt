package com.example.travelguide

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = ""

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        // (recyclerView.itemAnimator as? SimpleItemAnimator)?.isSupportChangeTypes = false

        val countries = getCountries()
        val adapter = CountryAdapter(this, countries)
        
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Setup FAB for chat
        val fabChat: FloatingActionButton = findViewById(R.id.fabChat)
        fabChat.setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_chat -> {
                startActivity(Intent(this, ChatActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getCountries(): List<Country> {
        return listOf(
            // ── Europa ──
            Country(1, "Portugal", R.drawable.flag_portugal, "Europa", "🇵🇹", "Lisboa", "EUR", "Português", "Mar–Out", 2),
            Country(2, "Espanha", R.drawable.flag_espanha, "Europa", "🇪🇸", "Madrid", "EUR", "Espanhol", "Mar–Jun", 2),
            Country(3, "França", R.drawable.flag_franca, "Europa", "🇫🇷", "Paris", "EUR", "Francês", "Abr–Jun", 3),
            Country(4, "Itália", R.drawable.flag_italia, "Europa", "🇮🇹", "Roma", "EUR", "Italiano", "Abr–Jun", 3),
            Country(5, "Alemanha", R.drawable.flag_alemanha, "Europa", "🇩🇪", "Berlim", "EUR", "Alemão", "Mai–Set", 3),
            Country(6, "Reino Unido", R.drawable.flag_uk, "Europa", "🇬🇧", "Londres", "GBP", "Inglês", "Abr–Set", 3),
            Country(7, "Suíça", R.drawable.flag_suica, "Europa", "🇨🇭", "Berna", "CHF", "Alemão", "Jun–Set", 3),
            Country(8, "Países Baixos", R.drawable.flag_holanda, "Europa", "🇳🇱", "Amesterdão", "EUR", "Holandês", "Abr–Set", 3),
            Country(9, "Bélgica", R.drawable.flag_belgica, "Europa", "🇧🇪", "Bruxelas", "EUR", "Holandês/Francês", "Mai–Set", 2),
            Country(10, "Áustria", R.drawable.flag_austria, "Europa", "🇦🇹", "Viena", "EUR", "Alemão", "Mai–Set", 3),
            Country(11, "Grécia", R.drawable.flag_grecia, "Europa", "🇬🇷", "Atenas", "EUR", "Grego", "Abr–Out", 2),
            Country(12, "Polónia", R.drawable.flag_polonia, "Europa", "🇵🇱", "Varsóvia", "PLN", "Polaco", "Mai–Set", 1),
            Country(13, "Irlanda", R.drawable.flag_irlanda, "Europa", "🇮🇪", "Dublin", "EUR", "Inglês", "Mai–Set", 3),
            Country(14, "Czech Republic", R.drawable.flag_checia, "Europa", "🇨🇿", "Praga", "CZK", "Checo", "Abr–Set", 1),
            Country(15, "Roménia", R.drawable.flag_romenia, "Europa", "🇷🇴", "Bucareste", "RON", "Romeno", "Mai–Set", 1),
            Country(16, "Hungria", R.drawable.flag_hungria, "Europa", "🇭🇺", "Budapeste", "HUF", "Húngaro", "Mai–Set", 1),
            Country(17, "Bulgária", R.drawable.flag_bulgaria, "Europa", "🇧🇬", "Sofia", "BGN", "Búlgaro", "Mai–Set", 1),
            Country(18, "Croácia", R.drawable.flag_croacia, "Europa", "🇭🇷", "Zagrebe", "EUR", "Croata", "Mai–Set", 2),
            Country(19, "Sérbia", R.drawable.flag_serbia, "Europa", "🇷🇸", "Belgrado", "RSD", "Sérvio", "Abr–Out", 1),
            Country(20, "Suécia", R.drawable.flag_suecia, "Europa", "🇸🇪", "Estocolmo", "SEK", "Sueco", "Mai–Set", 3),
            Country(21, "Noruega", R.drawable.flag_noruega, "Europa", "🇳🇴", "Oslo", "NOK", "Norueguês", "Jun–Set", 3),
            Country(22, "Dinamarca", R.drawable.flag_dinamarca, "Europa", "🇩🇰", "Copenhaga", "DKK", "Dinamarquês", "Mai–Set", 3),
            Country(23, "Finlândia", R.drawable.flag_finlandia, "Europa", "🇫🇮", "Helsínquia", "EUR", "Finlandês", "Jun–Set", 3),
            Country(24, "Islândia", R.drawable.flag_islandia, "Europa", "🇮🇸", "Reiquiavik", "ISK", "Islandês", "Jun–Set", 2),
            Country(25, "Moldávia", R.drawable.flag_moldavia, "Europa", "🇲🇩", "Chișinău", "MDL", "Romeno", "Abr–Jun", 1),
            Country(26, "Quénia", R.drawable.flag_kenya, "África", "🇰🇪", "Nairóbi", "KES", "Inglês/Suaíli", "Jul–Out", 2),
            Country(27, "Etiópia", R.drawable.flag_etiopia, "África", "🇪🇹", "Adis Abeba", "ETB", "Amárico", "Nov–Jan", 1),
            Country(28, "Tanzânia", R.drawable.flag_tanzania, "África", "🇹🇿", "Dodoma", "TZS", "Suaíli/Inglês", "Jun–Oct", 2),
            Country(29, "Nigéria", R.drawable.flag_nigeria, "África", "🇳🇬", "Abuja", "NGN", "Inglês", "Nov–Mar", 1),
            Country(30, "Gana", R.drawable.flag_ghana, "África", "🇬🇭", "Acra", "GHS", "Inglês", "Nov–Mar", 1),
            Country(31, "Senegal", R.drawable.flag_senegal, "África", "🇸🇳", "Dakar", "XOF", "Francês", "Nov–Mar", 1),
            Country(32, "Camarões", R.drawable.flag_camaroes, "África", "🇨🇲", "Yaoundé", "XAF", "Francês/Inglês", "Dec–Feb", 1),
            Country(33, "Tunísia", R.drawable.flag_tunisia, "África", "🇹🇳", "Túnis", "TND", "Árabe", "Mar–Mai", 1),
            Country(34, "Egito", R.drawable.flag_egito, "África", "🇪🇬", "Cairo", "EGP", "Árabe", "Out–Abr", 1),
            Country(35, "Marrocos", R.drawable.flag_marrocos, "África", "🇲🇦", "Rabat", "MAD", "Árabe", "Mar–Mai", 1),
            Country(36, "África do Sul", R.drawable.flag_south_africa, "África", "🇿🇦", "Pretória", "ZAR", "Inglês", "Abr–Set", 2),
            Country(37, "Cuba", R.drawable.flag_cuba, "América Central", "🇨🇺", "Havana", "CUP", "Espanhol", "Nov–Abr", 2),
            Country(38, "Rep. Dominicana", R.drawable.flag_repub_dom, "América Central", "🇩🇴", "Santo Domingo", "DOP", "Espanhol", "Dic–Abr", 2),
            Country(39, "Jamaica", R.drawable.flag_jamaica, "América Central", "🇯🇲", "Kingston", "JMD", "Inglês", "Nov–Abr", 2),
            Country(40, "Costa Rica", R.drawable.flag_costa_rica, "América Central", "🇨🇷", "San José", "CRC", "Espanhol", "Dic–Abr", 2),
            Country(41, "Panamá", R.drawable.flag_panama, "América Central", "🇵🇦", "Cidade do Panamá", "PAB", "Espanhol", "Jan–Abr", 2),
            Country(42, "Guatemala", R.drawable.flag_guatemala, "América Central", "🇬🇹", "Guatemala", "GTQ", "Espanhol", "Nov–Abr", 1),
            
            // ── Ásia ──
            Country(43, "Japão", R.drawable.flag_japao, "Ásia", "🇯🇵", "Tóquio", "JPY", "Japonês", "Mar–Mai", 3),
            Country(44, "China", R.drawable.flag_china, "Ásia", "🇨🇳", "Pequim", "CNY", "Mandarim", "Abr–Jun", 2),
            Country(45, "Coreia do Sul", R.drawable.flag_coreia, "Ásia", "🇰🇷", "Seul", "KRW", "Coreano", "Abr–Jun", 2),
            Country(46, "Índia", R.drawable.flag_india, "Ásia", "🇮🇳", "Nova Délhi", "INR", "Hindi/Inglês", "Out–Mar", 1),
            Country(47, "Tailândia", R.drawable.flag_tailandia, "Ásia", "🇹🇭", "Bangkok", "THB", "Tailandês", "Nov–Mar", 1),
            Country(48, "Singapura", R.drawable.flag_singapura, "Ásia", "🇸🇬", "Singapura", "SGD", "Inglês", "Jan–Mar", 3),
            Country(49, "Emirados Árabes", R.drawable.flag_uae, "Ásia", "🇦🇪", "Abu Dhabi", "AED", "Árabe", "Nov–Mar", 3),
            Country(50, "Turquia", R.drawable.flag_turquia, "Ásia/Europa", "🇹🇷", "Ancara", "TRY", "Turco", "Apr–Jun", 2),
            Country(51, "Vietnã", R.drawable.flag_vietnao, "Ásia", "🇻🇳", "Hanói", "VND", "Vietnamita", "Feb–Apr", 1),
            Country(52, "Malásia", R.drawable.flag_malasia, "Ásia", "🇲🇾", "Kuala Lumpur", "MYR", "Malaio", "Dez–Mar", 1),
            Country(53, "Indonésia", R.drawable.flag_indonesia, "Ásia", "🇮🇩", "Jacarta", "IDR", "Indonésio", "Mai–Set", 1),
            Country(54, "Filipinas", R.drawable.flag_filipinas, "Ásia", "🇵🇭", "Manila", "PHP", "Filipino/Inglês", "Nov-Apr", 1),
            Country(55, "Nepal", R.drawable.flag_nepal, "Ásia", "🇳🇵", "Katmandu", "NPR", "Nepalês", "Out–Mar", 1),
            Country(56, "Sri Lanka", R.drawable.flag_srilanka, "Ásia", "🇱🇰", "Colombo", "LKR", "Cingalês/Tamil", "Jan–Mar", 1),
            Country(57, "Israel", R.drawable.flag_israel, "Ásia", "🇮🇱", "Jerusalém", "ILS", "Hebraico/Árabe", "Out–Abr", 3),
            Country(58, "Arábia Saudita", R.drawable.flag_arabia, "Ásia", "🇸🇦", "Riyad", "SAR", "Árabe", "Nov–Mar", 3),
            
            // ── Oceania ──
            Country(59, "Austrália", R.drawable.flag_australia, "Oceania", "🇦🇺", "Canberra", "AUD", "Inglês", "Set–Nov", 3),
            Country(60, "Nova Zelândia", R.drawable.flag_nz, "Oceania", "🇳🇿", "Wellington", "NZD", "Inglês", "Out–Mar", 3),
        )
    }
}
