package com.example.travelguide

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CountryTipsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_tips)

        val toolbar: Toolbar = findViewById(R.id.toolbarTips)
        val flagImageView: ImageView = findViewById(R.id.countryFlagLarge)
        val nameTextView: TextView = findViewById(R.id.countryNameLarge)
        val detailsTextView: TextView = findViewById(R.id.countryDetails)
        val tipsRecyclerView: RecyclerView = findViewById(R.id.tipsRecyclerView)

        // Configurar toolbar
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

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
            4 -> { // Brasil
                listOf(
                    TravelTip(1, "CULTURA", "Gastronomia Brasileira", "Experimente a feijoada, o acarajé e os churrascos sulistas. O Brasil tem culinária diversa e deliciosa.", R.drawable.icon_comida),
                    TravelTip(2, "CULTURA", "Carnaval e Festas", "O Carnaval do Rio é o maior do mundo. Também experimente São João no Nordeste.", R.drawable.icon_cultura),
                    TravelTip(3, "TRANSPORTE", "Transporte no Brasil", "Use apps de transporte como Uber ou 99. Para longas distâncias, prefira voos internos.", R.drawable.icon_transporte),
                    TravelTip(4, "CULTURA", "Praias e Natureza", "O Brasil tem mais de 7.500 km de costa. Visite Fernando de Noronha, Jericoacoara e Lopes Mendes.", R.drawable.icon_cultura)
                )
            }
            5 -> { // Itália
                listOf(
                    TravelTip(1, "CULTURA", "Culinária Italiana", "Experimente massas frescas, pizzas napolitanas e gelato artesanal. Cada região tem pratos típicos únicos.", R.drawable.icon_comida),
                    TravelTip(2, "CULTURA", "Arte e História", "Visite o Vaticano, os museus de Florença e as ruínas de Pompeia. A Itália é um museu a céu aberto.", R.drawable.icon_cultura),
                    TravelTip(3, "TRANSPORTE", "Trenitalia e Frecce", "Os trens italianos são eficientes. Reserve com antecedência para obter melhores preços.", R.drawable.icon_transporte),
                    TravelTip(4, "CULTURA", "Vinhedos Italianos", "Visite a Toscana, Piedmont e Sicília para degustar wines tintos e brancos de classe mundial.", R.drawable.icon_cultura)
                )
            }
            6 -> { // Reino Unido
                listOf(
                    TravelTip(1, "CULTURA", "Culinária Britânica", "Experimente o tradicional English breakfast, fish and chips e o famoso afternoon tea.", R.drawable.icon_comida),
                    TravelTip(2, "CULTURA", "Monarquias e Castelos", "Visite o Palácio de Buckingham, a Torre de Londres e castelos medievais na Escócia.", R.drawable.icon_cultura),
                    TravelTip(3, "TRANSPORTE", "London Underground", "O metrô de Londres (Tube) é extenso e eficiente. Compre o Oyster Card para economizar.", R.drawable.icon_transporte),
                    TravelTip(4, "CULTURA", "Pub Culture", "Os pubs britânicos são parte da cultura. Experimente diferentes tipos de cerveja e cidra.", R.drawable.icon_cultura)
                )
            }
            7 -> { // Estados Unidos
                listOf(
                    TravelTip(1, "CULTURA", "Culinária Americana", "Experimente hambúrgueres, BBQ texano, pizza de Nova York e comida mexicana na Califórnia.", R.drawable.icon_comida),
                    TravelTip(2, "CULTURA", "Parques Nacionais", "Visite Yellowstone, Grand Canyon, Yosemite e Zion para paisagens naturais espetaculares.", R.drawable.icon_cultura),
                    TravelTip(3, "TRANSPORTE", "Alugar Carro", "Nos EUA, alugar carro é muitas vezes necessário. As distâncias entre cidades são grandes.", R.drawable.icon_transporte),
                    TravelTip(4, "CULTURA", "Cidades Icônicas", "Nova York, Los Angeles, Chicago e Miami têm atrações únicas e culturais diversas.", R.drawable.icon_cultura)
                )
            }
            8 -> { // Japão
                listOf(
                    TravelTip(1, "CULTURA", "Culinária Japonesa", "Experimente sushi, ramen, tempura e okonomiyaki. A comida japonesa é reconhecida mundialment.", R.drawable.icon_comida),
                    TravelTip(2, "CULTURA", "Tradições e Templos", "Visite templos em Quioto, o Templo Senso-ji em Tóquio e participe de uma cerimónia do chá.", R.drawable.icon_cultura),
                    TravelTip(3, "TRANSPORTE", "Japan Rail Pass", "O JR Pass permite viagens ilimitadas nos trens-bala. Reserve com antecedência.", R.drawable.icon_transporte),
                    TravelTip(4, "CULTURA", "Tecnologia e Inovação", "Explore Akihabara em Tóquio para eletrónica e anime. O Japão combina tradição com modernidade.", R.drawable.icon_cultura)
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
