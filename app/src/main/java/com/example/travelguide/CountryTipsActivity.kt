package com.example.travelguide

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CountryTipsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_tips)

        val flagImageView: ImageView = findViewById(R.id.countryFlagLarge)
        val nameTextView: TextView = findViewById(R.id.countryNameLarge)
        val detailsTextView: TextView = findViewById(R.id.countryDetails)
        val tipsRecyclerView: RecyclerView = findViewById(R.id.tipsRecyclerView)

        val country = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("country", Country::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("country") as? Country
        }

        country?.let {
            flagImageView.setImageResource(it.flagRes)
            nameTextView.text = it.name
            detailsTextView.text = "${it.capital} • ${it.currency} • ${it.language}"
            
            supportActionBar?.title = it.name
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            val travelTips = getTravelTipsForCountry(it.id)
            val adapter = TravelTipAdapter(travelTips)
            
            tipsRecyclerView.layoutManager = LinearLayoutManager(this)
            tipsRecyclerView.adapter = adapter
        }
    }

    private fun getTravelTipsForCountry(countryId: Int): List<TravelTip> {
        return when (countryId) {
            1 -> { // Portugal
                listOf(
                    TravelTip(1, "CULTURA", "Gastronomia Portuguesa", "Experimente o bacalhau, o pastel de nata e o vinho do Porto. A comida portuguesa é rica em sabores e tradições.", R.drawable.icon_comida),
                    TravelTip(2, "CULTURA", "Fado e Tradições", "Assista a um espetáculo de fado em Alfama, o bairro mais antigo de Lisboa, para sentir a alma portuguesa.", R.drawable.icon_cultura),
                    TravelTip(3, "TRANSPORTE", "Transporte Público", "Use o metro e os elétricos em Lisboa. Compre o Lisboa Card para acesso ilimitado.", R.drawable.icon_transporte),
                    TravelTip(4, "CULTURA", "Azulejos Portugueses", "Admire os azulejos coloridos nas igrejas e palácios. Cada um conta uma história da cultura portuguesa.", R.drawable.icon_cultura)
                )
            }
            2 -> { // Espanha
                listOf(
                    TravelTip(1, "CULTURA", "Tapas e Paella", "Experimente as tapas em bares tradicionais e não saia da Espanha sem provar a autêntica paella valenciana.", R.drawable.icon_comida),
                    TravelTip(2, "CULTURA", "Flamenco e Arte", "Assista a um espetáculo de flamenco em Sevilha ou Granada para sentir a paixão espanhola.", R.drawable.icon_cultura),
                    TravelTip(3, "TRANSPORTE", "AVE - Trem Alta Velocidade", "O AVE conecta as principais cidades espanholas. É rápido, confortável e pontual.", R.drawable.icon_transporte),
                    TravelTip(4, "CULTURA", "Arquitetura Gaudí", "Visite as obras de Gaudí em Barcelona, incluindo a Sagrada Família e Park Güell.", R.drawable.icon_cultura)
                )
            }
            3 -> { // França
                listOf(
                    TravelTip(1, "CULTURA", "Cozinha Francesa", "Deguste queijos, vinhos e pães artesanais. Não deixe de experimentar croissants e macarons.", R.drawable.icon_comida),
                    TravelTip(2, "CULTURA", "Museus de Paris", "Visite o Louvre, Museu d'Orsay e Centre Pompidou. Compre o Paris Museum Pass para economizar.", R.drawable.icon_cultura),
                    TravelTip(3, "TRANSPORTE", "Metrô de Paris", "O metrô parisiense é a melhor forma de explorar a cidade. Compre bilhetes de carnet para economizar.", R.drawable.icon_transporte),
                    TravelTip(4, "CULTURA", "Regiões Vinícolas", "Visite Bordeaux, Champagne ou Bourgogne para degustações e tours pelas vinícolas.", R.drawable.icon_cultura)
                )
            }
            else -> emptyList()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
