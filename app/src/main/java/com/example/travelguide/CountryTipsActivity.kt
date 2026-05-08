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
                    TravelTip(1, "GASTRONOMIA", "Bacalhau e Pratos Típicos", "O bacalhau é o prato nacional - diz-se que há 365 receitas diferentes! Experimente também a caldeirada, o cozido à portuguesa e as sardinhas assadas.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Doces e Pastéis", "O pastel de nata de Belém é imperdível -出炉 ainda quente! Experimente também travesseiros de Sintra, queijadas de Setúbal e arroz doce.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Fado e Música Tradicional", "O fado é património imaterial da UNESCO. Os bairros de Alfama e Mouraria em Lisboa são os melhores lugares para ouvir fado ao vivo.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Azulejos e Arquitetura", "Os azulejos azuis e brancos contam histórias de Portugal. Visite o Palácio Nacional da Ajuda, a Igreja de São Vicente de Fora e o Museu do Azulejo.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transportes em Lisboa", "O metro é limpo e eficiente. Os elétricos históricos (28 e 15) são atrações turísticas. O Viva Viagem é o cartão de transporte recarregável.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Melhor Época para Visitar", "A primavera (abril-maio) e outono (setembro-outubro) oferecem clima agradável e menos turistas. O verão é quente mas muito movimentado.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Onde Ficar em Lisboa", "As zonas de Baixa, Chiado e Alfama são as mais centrais. Para quem busca sossego, Belém ou Parque das Nações são boas opções.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Custo de Vida", "Portugal é relativamente acessível para Europa. Uma refeição em restaurante médio custa 15-25€, café 1,50€, transporte metro 1,80€.", R.drawable.icon_cultura)
                )
            }
            2 -> { // Espanha
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Tapas e Pintxos", "As tapas são pequenas porções para partilhar. Em Barcelona experimente a tortilla española, as patatas bravas e o jamón ibérico. Nos bascos, os pintxos são estrelas!", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Paella e Arroz", "A paella valenciana é o prato mais famoso. Experimente também a fideuá (arroz com massa), o arroz negro e a paella de marisco.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Flamenco", "O flamenco é emoção pura! Sevilha, Granada e Cádiz são os melhores lugares para espetáculos autênticos. O tablao é o local tradicional.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Arquitetura de Gaudí", "Barcelona é a capital do modernismo. A Sagrada Família, Park Güell, Casa Batlló e La Pedrera são obras-primas arquitetónicas indispensáveis.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Trem AVE de Alta Velocidade", "O AVE conecta Madrid a Barcelona em menos de 3 horas. Reserve com 2-3 meses de antecedência para melhores preços (25-60€).", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Siesta e Horários", "Muitos negócios fecham entre 14h-17h. O jantar começa às 21h ou mais tarde. Planeie suas atividades respeitando o ritmo local.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Festas Populares", "A Feria de Abril em Sevilha (abril), La Tomatina em Buñol (agosto) e as Festas de San Juan em Madrid (junho) são eventos únicos.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Regiões Turísticas", "Andalucía (Sevilha, Granada, Córdoba), Cataluña (Barcelona, Costa Brava), Ilhas Baleares (Mallorca, Ibiza) e País Basco (San Sebastián, Bilbao).", R.drawable.icon_cultura)
                )
            }
            3 -> { // França
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Queijos e Vinhos", "A França tem mais de 1.000 tipos de queijo! O camembert, roquefort e brie são clássicos. Para vinhos, Bordeaux, Borgonha e Champagne são imperdíveis.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Padaria e Pastelaria", "Os croissants e pain au chocolat são divinais. Experimente também macarons, éclairs, tartes Tatin e as crepes na Bretanha.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Museus de Paris", "O Louvre é o maior museu do mundo (ver a Mona Lisa). O Musée d'Orsay tem impressionistas. O Centre Pompidou e Louis Vuitton são modernos.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Monumentos Icónicos", "A Torre Eiffel, Catedral de Notre-Dame, Arco do Triunfo e Champs-Élysées são imperdíveis. Suba ao topo da torre ao pôr do sol!", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Metrô de Paris", "O metro é o meio mais fácil de se deslocar. Um bilhete t+ custa 2,10€. O Navigo Decouverte é económico para estadias longas.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Paris Museum Pass", "O passe permite acesso ilimitado a mais de 60 museus e monumentos. Custa 35€/2 dias, 55€/4 dias e 70€/6 dias - vale a pena!", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Regiões Vinícolas", "Bordeaux (castelos e tintos), Champagne (caves de espumante), Borgonha (vinhos brancos), Vale do Loire (castelos e brancos).", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Cultura do Café", "Os cafés parisienses são instituições. Café de Flore, Les Deux Magots e Café de la Paix são históricos. Sentar num terraço é experiência obrigatória.", R.drawable.icon_cultura)
                )
            }
            4 -> { // Brasil
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Feijoada e Churrasco", "A feijoada completa com arroz, couve, laranja e cachaça é o prato nacional. O churrasco sulista (gaucho) é reconhecido mundialmente.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Culinária Regional", "O acarajé e vatapá da Bahia, a moqueca capixaba, o barreado do Paraná e a pizza de São Paulo são especialidades regionais imperdíveis.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Carnaval", "O Carnaval do Rio é o maior do mundo! Os desfiles na Sapucaí são espetaculares. O Carnaval de Salvador e Recife também são famosos.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Praias e Natureza", "O Brasil tem 7.500 km de costa. Fernando de Noronha, Jericoacoara, Lopes Mendes (Ilha Grande) e as praias de Fernando de Noronha são paradisíacas.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Interno", "As distâncias são enormes! Use voos para longas distâncias (Latam, Gol, Azul). Em cidades, use Uber ou 99. O metrô existe em SP, Rio, BH e Salvador.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Melhor Época", "O Brasil é grande - cada região tem seu clima. O Sul e Sudeste têm invernos frios (maio-setembro). O Norte tem época seca (junho-novembro).", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Segurança", "Evite áreas風險as à noite. Não use joias ou objetos de valor nas praias. Mantenha documentos seguros. Em caso de emergência, disque 190.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Idioma e Comunicação", "O português brasileiro é diferente do europeu. O inglês é falado em hotéis e restaurantes turísticos. Aprenda algumas frases básicas!", R.drawable.icon_cultura)
                )
            }
            5 -> { // Itália
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Massas e Pizza", "Cada região tem massas típicas! O ragù bolonhesa, carbonara romana e pesto genovês são clássicos. A pizza napolitana é património UNESCO.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Gelato e Café", "O gelato italiano é mais denso e menos gorduroso que o americano. Experimente pistacho, stracciatella e nocciola. O espresso é perfeito após as refeições!", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Vaticano e Roma", "Os Museus Vaticanos (Capela Sistina), Coliseu, Fórum Romano e Fontaine di Trevi são imperdíveis. Reserve entradas com antecedência!", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Arte em Florença", "Florença é berço do Renascimento. A Galleria degli Uffizi tem Botticelli, Leonardo e Michelangelo. O Duomo e a Accademia (David) são obrigatórios.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Trenitalia e Frecce", "Os trens alta velocidade (Frecce) são confortáveis. Reserve com antecedência no site oficial. A segunda classe é excelente e mais económica.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "La Dolce Vita", "Os italianos valorizam a vida. O aperitivo (happy hour com comida) é tradição. O jantar começa às 20h-21h. Desfrute do ritmo relaxado!", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Vinhedos Italianos", "A Toscana (Chianti), Piedmont (Barolo), Veneto (Prosecco) e Sicília são regiões vinícolas famosas. Faça degustações e tours por vinhas.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Vestuário em Igrejas", "Vista-se apropriadamente para igrejas (ombos e joelhos cobertos). A Vaticana, Milão e Florença têm regras rigorosas. Leve um lenço para cobrir-se.", R.drawable.icon_cultura)
                )
            }
            6 -> { // Reino Unido
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Britânica", "O full English breakfast (ovos, bacon, salsichas, feijões, toast) é energético. O fish and chips tradicional é imperdível em coastal towns.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Afternoon Tea", "A tradição do chá das 16h inclui sandwiches, scones com cream cheese e bolos. O Ritz e o Claridge's em Londres são lendários.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Monarquias e Palácios", "O Palácio de Buckingham muda de guarda às 11h30. A Torre de Londres tem joias da coroa. Windsor Castle é a residência real mais antiga.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Castelos e História", "Edimburgo (Escócia), Warwick, Dover e Cardiff são castelos impressionantes. A história britânica vai dos romanos aos vikings.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "London Underground", "O Tube é extenso e eficiente. O Oyster Card é obrigatório - toque para entrar e sair. O contactless (cartão sem contacto) também funciona.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Pub Culture", "Os pubs são o coração da comunidade. Peça no balcão (não há mesas para pedir). Cervejas como bitter, lager e stout são típicas. O Sunday roast é tradição!", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Clima e Vestuário", "O tempo é imprevisível - leve camadas e guarda-chuva! Mesmo em verão, um casaco é essencial. A chuva aparece sem aviso.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Moeda e Pagamentos", "A libra esterlina (£) é forte. Muitos lugares não aceitam euros. Cartões são amplamente aceites. Gorjetas de 10-15% são habituais.", R.drawable.icon_cultura)
                )
            }
            7 -> { // Estados Unidos
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Americana", "Hambúrgueres e hot dogs são clássicos. O BBQ texano e de St. Louis é lendário. A pizza de Nova York e a comida mexicana na Califórnia são imperdíveis.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Cidades Gastronómicas", "Nova Orleans (cajun/creole), São Francisco (mission burritos), Nova York (todas as cozinhas do mundo) e Austin (BBQ) são destinos culinários.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Parques Nacionais", "Yellowstone, Grand Canyon, Yosemite, Zion e Arches são espetaculares. O pass America the Beautiful ($80/ano) dá acesso a todos os parques.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Cidades Icónicas", "Nova York (Estátua da Liberdade, Times Square), Los Angeles (Hollywood, beaches), Chicago (arquitetura, música) e Miami (South Beach) são únicas.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Alugar Carro", "Em muitos estados, carro é essencial. As distâncias são enormes. Alugue em aeroportos - é mais barato. Compare preços em agregadores.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Gorjetas (Tipping)", "Gorjetas são obrigatórias! 15-20% em restaurantes, $1-2 por bebida no bar, $2-5 por noite em hotéis. Serviços não incluem gorjeta.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Custo de Vida", "Os EUA são caros.fast food $10, refeição média $20-30, combustível $0,70/litro (muito mais barato que Europa). Hotéis fora de cidades são mais económicos.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Segurança em Viagem", "Evite áreas perigosas à noite. Mantenha pertences visíveis. Em emergências, disque 911. O sistema de saúde é privado - tenha seguro!", R.drawable.icon_cultura)
                )
            }
            8 -> { // Japão
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Sushi e Frutos do Mar", "O sushi de Tsukiji em Tóquio é lendário. Experimente omakase (chef's choice). O Kaiseki (refeição tradicional) é uma experiência única.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Ramen e Izakaya", "O ramen é conforto japonês - o caldo de osso de porco é divino. Izakayas são bares com petiscos. Experimente yakitori (frango na brasa).", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Templos e Santuários", "O Fushimi Inari em Quioto (portões vermelhos), Senso-ji em Tóquio e Itsukushima (torii no mar) são imperdíveis. Respeite as regras de etiqueta.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Tradições e Cerimónias", "A cerimónia do chá é meditação. O karaokê é entretenimento nacional. Onsen (termas) são relaxantes. O matsuri (festival) acontece em cada cidade.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Japan Rail Pass", "O JR Pass permite viagens ilimitadas nos shinkansen (comboios-bala). Reserve antes de chegar ao Japão - é válido apenas para turistas.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Etiqueta Japonês", "Use ambas as mãos para dar/receber cartões. Não coma a caminhar. Cumprimente com vénia (inclinar-se). Silêncio no metro é essencial.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Tóquio e Cidades", "Tóquio (Shibuya, Shinjuku, Akihabara), Quioto (templos), Osaka (comida), Hiroshima (memorial) e Nara (veados) são destinos principais.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Dinheiro e Pagamentos", "O Japão ainda usa muito dinheiro. Tenha sempre yen consigo. Cartões são aceites em grandes lojas. O Suica/Pasmo é o cartão de transporte.", R.drawable.icon_cultura)
                )
            }
            9 -> { // Alemanha
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Cerveja e Bebidas", "A Alemanha tem mais de 1.500 cervejas! A Reinheitsgebot (lei da pureza) é histórica. Experimente Weizenbier, Pilsner e Dunkel em breweries tradicionais.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Pratos Alemães", "O Schnitzel (escalope empanizado) é clássico. O Sauerbraten (carne marinada) e os Würstel (enchidos) são imperdíveis. O pretzel é lanche popular.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Castelos e Contos de Fadas", "Neuschwanstein inspirou o castelo da Disney. Os contos de Grimm vêm da Alemanha. Visite castelos no Vale do Reno e na Baviera.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "História e Muro de Berlim", "O Muro de Berlim e Checkpoint Charlie são memória histórica. O Holocaust Memorial e os museus são comoventes mas importantes.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Deutsche Bahn", "Os comboios alemães são pontuais e confortáveis. O BahnCard dá descontos. O regionale é económico para curtas distâncias.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Mercados de Natal", "Os mercados de Natal alemães são os mais tradicionais! Nuremberg, Dresden, Colónia e Munique têm decorações mágicas e Glühwein (vinho quente).", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", " Oktoberfest", "O festival de Munique (setembro-outubro) é o maior do mundo. Reserve hotel com meses de antecedência. Vista-se com traje tradicional (Dirndl/Lederhosen).", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Custo e Pagamentos", "A Alemanha usa euro. Cartões são amplamente aceites. Contactless está disponível. Propina não é obrigatória mas apreciada.", R.drawable.icon_cultura)
                )
            }
            10 -> { // Canadá
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Canadiana", "O poutine (batatas fritas com molho e queijo) é prato nacional. O maple syrup é melhor fresco. O Nanaimo bar é doce típico da Colúmbia Britânica.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Frutos do Mar", "O lobster (lagosta) de Nova Scotia é famoso. O salmon selvagem da Colúmia Britânica é excelente. As ostras de Vancouver são premiadas.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Parques Nacionais", "Banff e Jasper nas Montanhas Rochosas são espetaculares. O Parque Nacional de Kejimkujik e o Niagara são outros destaques. A natureza é selvagem e linda.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Cidades Multiculturais", "Toronto é a cidade mais multicultural do mundo. Vancouver, Montreal e Ottawa têm bairros étnicos vibrantes. Cada cidade tem personalidade única.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Interno", "As distâncias são enormes! Voos internos são económicos (Air Canada, WestJet). Em cidades, use metro e autobustos. Alugar carro é recomendado para natureza.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Melhor Época", "O inverno é rigoroso (-30°C em algumas zonas). O verão (junho-agosto) é ideal para natureza. Outono tem cores espetaculares. Reserve com antecedência!", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Idioma", "O inglês é dominante. No Quebec, o francês é oficial. Muitos sinais são bilingues. Em Montreal, francês ajuda mas inglês é aceite.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Natureza e Vida Selvagem", "Veja auroras boreais no Yukon (setembro-outubro). Os ursos negros e moose são comuns. Respeite a natureza - mantenha distância de animais.", R.drawable.icon_cultura)
                )
            }
            11 -> { // Austrália
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Australiana", "O meat pie é lanche nacional. O Tim Tam (biscoito de chocolate) é viciante. O avocado toast australian é famoso mundialmente. O flat white coffee é criação local.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Frutos do Mar", "A barra de ostras de Sydney é lendária. O lobster de Western Australia e o abalone são iguarias. O fish and chips à beira-mar é experiência obrigatória.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Praias icónicas", "Bond Beach em Sydney, Gold Coast (surfe), Whitehaven (Whitsundays) e Cable Beach (Broome) são algumas das melhores praias do mundo.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Vida Selvagem", "A Grande Barreira de Corais é maior do mundo (2.300 km). Veja coalas, cangurus, dingos e ornitorrincos. A biodiversidade é única no planeta.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Explorar a Austrália", "As distâncias são imensas! Voos internos (Qantas, Virgin, Jetstar) são essenciais. Alugar carro é recomendado para liberdade. As estradas são boas.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Cultura Aborígene", "A cultura indígena australiana tem 65.000+ anos - a mais antiga do mundo. Uluru (Ayers Rock) é sagrado para os Anangu. Respeite as tradições.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Melhor Época", "O norte (Darwin) tem estações secas/chuvosas. O sul (Sydney, Melbourne) tem 4 estações. O inverno (junho-agosto) é ideal para sul; seco para norte.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Custo de Vida", "A Austrália é cara. Orçamento diário: AU$100-150 (backpacker), AU$200+ (conforto). Hostels $30-50, hotéis $150+, refeições $15-30.", R.drawable.icon_cultura)
                )
            }
            12 -> { // México
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Mexicana", "A comida mexicana é património UNESCO! Os tacos (especialidade local), mole (molho complexo), pozole (sopa de milho) e tamales são imperdíveis.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Bebidas Típicas", "A tequila e mezcal são orgulho mexicano. A michelada (cerveja com limão e molho) é refrescante. O chocolate quente mole é divino.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Ruínas Maias e Astecas", "Chichén Itzá (uma das novas 7 maravilhas), Teotihuacán (pirâmides do sol/lua), Tulum e Palenque são sítios arqueológicos espetaculares.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Dia dos Mortos", "O Día de los Muertos (31 outubro - 2 novembro) é único! Altares (ofrendas), calaveras decoradas e procissões em Michoacán são experiências profundas.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte no México", "O ADO é a principal empresa de ônibus - confortável e económico. Voos internos (Volaris, Interjet) são acessíveis. Em cidades, use Uber.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Cidades Turísticas", "Cidade do México (museus, gastronomia), Cancún/Riviera Maya (praias), Guadalajara (tequila, mariachi), Oaxaca (cultura), Mérida (Mayas).", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Segurança", "Algumas zonas têm problemas de segurança. Evite zonas de risco à noite. Não beba água da torneira. Use protector solar forte - o sol é forte!", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Idioma", "O espanhol é predominante. Em zonas turísticas, inglês é falado. Aprenda básicas: hola (olá), gracias (obrigado), por favor (por favor), cuanto cuesta? (quanto custa?).", R.drawable.icon_cultura)
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
