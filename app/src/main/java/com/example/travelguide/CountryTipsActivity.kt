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
                    TravelTip(6, "PESSOAS", "Figuras Importantes", "Luís de Camões (poeta), Vasco da Gama (navegador), Fernando Pessoa (poeta), Cristiano Ronaldo (futebol), Amália Rodrigues (fadista).", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Melhor Época para Visitar", "A primavera (abril-maio) e outono (setembro-outubro) oferecem clima agradável e menos turistas. O verão é quente mas muito movimentado.", R.drawable.icon_cultura),
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
                    TravelTip(6, "PESSOAS", "Figuras Importantes", "Pablo Picasso (pintor), Salvador Dalí (pintor), Antoni Gaudí (arquiteto), Rafael Nadal (ténis), Fernando Torres (futebol).", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Siesta e Horários", "Muitos negócios fecham entre 14h-17h. O jantar começa às 21h ou mais tarde. Planeie suas atividades respeitando o ritmo local.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Festas Populares", "A Feria de Abril em Sevilha (abril), La Tomatina em Buñol (agosto) e as Festas de San Juan em Madrid (junho) são eventos únicos.", R.drawable.icon_cultura)
                )
            }
            3 -> { // França
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Queijos e Vinhos", "A França tem mais de 1.000 tipos de queijo! O camembert, roquefort e brie são clássicos. Para vinhos, Bordeaux, Borgonha e Champagne são imperdíveis.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Padaria e Pastelaria", "Os croissants e pain au chocolat são divinais. Experimente também macarons, éclairs, tartes Tatin e as crepes na Bretanha.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Museus de Paris", "O Louvre é o maior museu do mundo (ver a Mona Lisa). O Musée d'Orsay tem impressionistas. O Centre Pompidou e Louis Vuitton são modernos.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Monumentos Icónicos", "A Torre Eiffel, Catedral de Notre-Dame, Arco do Triunfo e Champs-Élysées são imperdíveis. Suba ao topo da torre ao pôr do sol!", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Metrô de Paris", "O metro é o meio mais fácil de se deslocar. Um bilhete t+ custa 2,10€. O Navigo Decouve é económico para estadias longas.", R.drawable.icon_transporte),
                    TravelTip(6, "PESSOAS", "Figuras Importantes", "Napoleão Bonaparte (imperador), Marie Curie (cientista), Coco Chanel (designer), Zinedine Zidane (futebol), Victor Hugo (escritor).", R.drawable.icon_cultura),
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
                    TravelTip(6, "PESSOAS", "Figuras Importantes", "Leonardo da Vinci (artista), Michelangelo (artista), Alexandre Magno (conquistador), Dante Alighieri (poeta), Fabio Cannavaro (futebol).", R.drawable.icon_cultura),
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
                    TravelTip(6, "PESSOAS", "Figuras Importantes", "William Shakespeare (escritor), Isaac Newton (cientista), Winston Churchill (político), Beatles (banda), David Beckham (futebol).", R.drawable.icon_cultura),
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
                    TravelTip(6, "PESSOAS", "Figuras Importantes", "Barack Obama (ex-presidente), Elon Musk (empresário), Michael Jordan (basquetebol), Taylor Swift (cantora), Steve Jobs (fundador Apple).", R.drawable.icon_cultura),
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
                    TravelTip(6, "PESSOAS", "Figuras Importantes", "Hayao Miyazaki (diretor anime), Yoshihide Suga (ex-primeiro ministro), Naomi Osaka (ténis), Hikaru Utada (cantora), Takeshi Kitano (cineasta).", R.drawable.icon_cultura),
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
                    TravelTip(6, "PESSOAS", "Figuras Importantes", "Albert Einstein (cientista), Angela Merkel (ex-chanceler), Ludwig van Beethoven (compositor), Michael Schumacher (F1), Martin Luther King (ativista).", R.drawable.icon_cultura),
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
                    TravelTip(6, "PESSOAS", "Figuras Importantes", "Justin Trudeau (primeiro ministro), Wayne Gretzky (hóquei), Drake (cantor), Jim Carrey (ator), Margaret Atwood (escritora).", R.drawable.icon_cultura),
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
                    TravelTip(6, "PESSOAS", "Figuras Importantes", "Hugh Jackman (ator), Cate Blanchett (atriz), Steve Irwin (naturalista), Ian Thorpe (natação), Kylie Minogue (cantora).", R.drawable.icon_cultura),
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
                    TravelTip(6, "PESSOAS", "Figuras Importantes", "Frida Kahlo (pintora), Diego Rivera (pintor), Gael García Bernal (ator), Canelo Álvarez (boxe), Guillermo del Toro (cineasta).", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Segurança", "Algumas zonas têm problemas de segurança. Evite zonas de risco à noite. Não beba água da torneira. Use protector solar forte - o sol é forte!", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Idioma", "O espanhol é predominante. Em zonas turísticas, inglês é falado. Aprenda básicas: hola (olá), gracias (obrigado), por favor (por favor), cuanto cuesta? (quanto custa?).", R.drawable.icon_cultura)
                )
            }
            13 -> { // Argentina
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Asado Argentino", "O churrasco argentino é lendário! A carne de qualidade superior é grelhada em brasas. Experimente em parillas tradicionais.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Doces e Mate", "O dulce de leche é везде! O mate é a bebida social - compartilhe com os locais. Empadinhas e alfajores são imperdíveis.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Buenos Aires", "A capital é chamada de Paris sul-americana. O Teatro Colón, Caminito em La Boca e a Avenida 9 de Julio são imperdíveis.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Patagónia", "A Patagónia argentina tem paisagens espetaculares! O glaciar Perito Moreno e o Monte Fitz Roy são destinos de sonho.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Interno", "Os ônibus de longa distância (ómnibus) são confortáveis. Os voos internos (Aerolíneas Argentinas) ligam as principais cidades.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Melhor Época", "A primavera (setembro-novembro) e outono (março-maio) são ideais. O inverno é frio mas bom para esquiar na Patagónia.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Moeda", "O peso argentino tem variação. Use dólares ou euros para cambiar. O mercado paralelo (blue) tem melhor taxa.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Cultura do Tango", "O tango é património UNESCO. Assista a um espetáculo em milongas tradicionais ou nas ruas de San Telmo.", R.drawable.icon_cultura)
                )
            }
            14 -> { // Chile
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Chilena", "O pastel de choclo (torta de milho), o completo (hot dog chileno) e os mariscos são imperdíveis. O vinho chileno é excelente!", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Frutos do Mar", "A região de Valparaíso e o norte têm frutos do mar fresquinhos. As machas (amêijoas) e o erizo (ouriço do mar) são especialidades.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Santiago", "A capital andina tem museus, mercados e a Cerro Santa Lucía. Os Andes são visíveis da cidade!", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Atacama e Patagónia", "O deserto de Atacama é o mais seco do mundo. A Patagónia chilena tem glaciares e montanhas espetaculares.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Interno", "O LAN é a principal companhia aérea. Os ônibus de longa distância são económicos e confortáveis.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Geografia Extrema", "O Chile tem 4.300 km de norte a sul! O clima varia enormemente. Prepare-se para desertos, florestas e glaciares.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Ilha de Páscoa", "Rapa Nui é um destino único no mundo. As estátuas Moai são misteriosas e impressionantes. Reserve 4-5 dias.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Custo de Vida", "Santiago é relativamente acessível. O sul é mais caro. O vinho e os frutos do mar são baratos e frescos.", R.drawable.icon_cultura)
                )
            }
            15 -> { // Colômbia
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Colombiana", "A bandeja paisa é o prato principal - feijão, arroz, carne, abacate e ovo! Os arepas são versáteis e deliciosas.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Café Colombiano", "A Colômbia é famosa pelo café! Visite fazendas de café na região do Eje Cafetero. O café colombiano é suave e aromático.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Cartagena", "A cidade colonial murada é património UNESCO. As ruas de paralelepípedos, igrejas barrocas e varandas floridas são mágicas.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Cultura e História", "Bogotá tem museus gold (ouro), arte colonial e a Candelária histórica. A história pré-colombiana é fascinante.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Interno", "Voos internos (Avianca, Latam, Viva) são económicos. Os ônibus são confortáveis. Em cidades, use Uber.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Segurança", "Algumas zonas têm problemas. Evite áreas de risco. Não mostre objetos de valor. Use transporte seguro à noite.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Clima", "Devido à altitude, Bogotá é fresca (15-20°C). O Caribe é quente (30°C). A Amazônia é tropical. Leve camadas!", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Festivais", "O Carnaval de Barranquilla (fevereiro) é um dos maiores do mundo. A Feria de Manizales é famosa. Festivais de música em Medellín!", R.drawable.icon_cultura)
                )
            }
            16 -> { // Peru
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Peruana", "O Peru é destino gastronómico de elite! O ceviche (peixe cru em limão), lomo saltado e a causa (torta de batata) são imperdíveis.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Alta Cozinha", "Lima tem restaurantes world-class (Central, Maido). A fusão nikkei (japonesa-peruana) é única no mundo.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Machu Picchu", "A cidade Inca suspensa é uma das novas 7 maravilhas. Reserve com antecedência - lota rapidamente!", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Lima e Cusco", "Lima tem museus e gastronomia. Cusco é portal para Machu Picchu e tem arquitetura Inca bem preservada.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Interno", "Os voos internos (Latam, Sky) são essenciais para longas distâncias. Os ônibus são económicos mas lentos.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Altitude", "Cusco e Machu Picchu estão a 2.400-3.400m. Leve coca (chá ou pastilhas) para evitar enjoo. Hydratize-se!", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Melhor Época", "A época seca (maio-setembro) é melhor para Machu Picchu. O clima é imprevisível - prepare-se para chuva.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Turismo Sustentável", "Respeite os sítios arqueológicos. Contrate guias locais. Não compre artesanato de animais protegidos.", R.drawable.icon_cultura)
                )
            }
            17 -> { // China
                listOf(
                    TravelTip(1, "GASTRONOMIA", "8 Culinárias Regionais", "A China tem 8 grandes cozinhas! Peking duck (Pequim), dim sum (Cantão), Sichuan (picante) são imperdíveis.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Street Food", "Os mercados noturnos são experiências únicas! Experimente dumplings, noodles, kebabs e frutas exóticas.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Muralha da China", "A Grande Muralha é visível do espaço! As secções de Badaling (turística) e Mutianyu (bonita) são mais acessíveis.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Exércitos e Templos", "O exército de terracota em Xi'an é inúmerol! O Templo do Céu em Pequim e os Jardins Suzhou são património UNESCO.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Trem de Alta Velocidade", "A China tem a maior rede de comboios de alta velocidade do mundo. Conecta todas as principais cidades rapidamente.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Great Firewall", "O acesso à internet é restrito. Use VPN antes de chegar. O WeChat é essencial para tudo.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Idioma", "O mandarim é o idioma principal. Poucos falam inglês fora das grandes cidades. Aprenda frases básicas ou use tradutor.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Cultura e Etiqueta", "O negócio de cartões é importante. Não dê pontapés em cadeiras. Ofereça cartões com ambas as mãos. Respeite os mais velhos.", R.drawable.icon_cultura)
                )
            }
            18 -> { // Coreia do Sul
                listOf(
                    TravelTip(1, "GASTRONOMIA", "BBQ e Kimchi", "O bulgogi (carne grelhada) e o samgyeopsal (bacon de porco) são imperdíveis. O kimchi (legumes fermentados) acompanha todas as refeições!", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Street Food", "Os mercados noturnos (Myeongdong, Hongdae) vendem tudo! Tteokbokki (bolo de arroz picante), kimbap e fried chicken são viciantes.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Seoul", "A capital é uma mistura de tradição e modernidade! Palácios Joseon, bairros tecnológicos e K-pop estão por toda parte.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "K-Pop e K-Drama", "A Coreia exporta cultura! Os estúdios de K-pop em Gangnam e as locais de filmagem de dramas são turísticos.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Metro e KTX", "O metro de Seul é eficiente e barato. O KTX (comboio-bala) conecta as principais cidades em horas.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Cultura do Café", "A Coreia tem cultura de café única! Os cafés temáticos ( gato, pastelaria, livros) são experiências em si.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Cosméticos", "A Coreia é líder em cosméticos! Os produtos são acessíveis e de qualidade. As lojas em Myeongdong têm promoções.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Saunas e Spas", "Os jjimjilbang (spas coreanos) são experiências únicas. Passam a noite, coma, durma e relaxe por poucos euros!", R.drawable.icon_cultura)
                )
            }
            19 -> { // Índia
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Indiana", "Cada região tem sabores únicos! O curry, biryani, dosa e samosa são imperdíveis. O vegetarianismo é comum.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Chá e Especiarias", "O chai (chá com especiarias) é везде! As especiarias da Índia são as melhores do mundo. Visite mercados de especiarias.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Taj Mahal", "O Taj Mahal é uma das novas 7 maravilhas! Construído por Shah Jahan em memória da esposa. Amanhecer é mágico.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Varanasi e Hinduísmo", "Varanasi é a cidade sagrada dos hindus. Os ghats (cais) e as cerimónias ao pôr do sol são experiências profundas.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte na Índia", "O metro existe em Delhi e Mumbai. Os trens são económicos mas lotados. Reserve AC para longas distâncias.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Saúde e Higiene", "Beba apenas água engarrafada. Evite gelo de origem desconhecida. Leve medicamentos básicos e repelente.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Regiões Turísticas", "Delhi (capital), Rajasthan (palácios), Kerala (backwaters), Goa (praias), Varanasi (espiritualidade) são destinos principais.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Barganha", "A barganha é esperada em mercados! Comece em 30-40% do preço pedido. Sorria e seja respeitoso.", R.drawable.icon_cultura)
                )
            }
            20 -> { // Tailândia
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Tailandesa", "O equilíbrio doce/salgado/ácido/picante é único! O pad thai, green curry, som tam e massaman curry são imperdíveis.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Street Food", "A Tailândia é paraíso do street food! Os mercados noturnos têm centenas de opções. Bangkok é a capital mundial da street food.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Templos e Budismo", "O Templo do Buda de Esmeralda em Bangkok e os templos de Chiang Mai são impressionantes. Respeite o código de vestuário.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Ilhas e Praias", "Phuket, Koh Samui, Koh Phi Phi e Koh Lanta têm praias paradisíacas. O mar de Andaman e o Golfo da Tailândia são belos.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Interno", "Os voos internos (AirAsia, Bangkok Airways) são económicos. Os songthaews (camiões abertos) são típicos. Os ferries ligam ilhas.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Custo de Vida", "A Tailândia é muito acessível. Refeições de street food custam 1-3€. Quartos de hotel por 10-20€. Massagens por 5-10€.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Festivais", "O Songkran (ano novo tailandês, abril) é o maior festival de água do mundo. O Loy Krathong (lanternas) é mágico.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Respeito e Cultura", "Nunca toque na cabeça de alguém. Não aponte os pés para budas. Vista-se modestamente em templos.", R.drawable.icon_cultura)
                )
            }
            21 -> { // Singapura
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Hawker Centers", "Os hawker centers são o coração da gastronomia! O frango chiars (frango Hainanese) e o laksa são imperdíveis.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Culinária Multicultural", "A comida reflete as culturas! Chinesa, malaia, indiana e ocidental coexistem. Os mercados de Chinatown são completos.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Marina Bay e Gardens", "Os Gardens by the Bay são futuristas! A Supertree Grove e a Cloud Forest são espetaculares. A vista do Marina Bay Sands é incrível.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Diversidade Cultural", "Chinatown, Little India e Kampong Glam são bairros distintos. Cada um tem templos, lojas e gastronomia única.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Público", "O metro (MRT) é limpo, eficiente e barato. Os ônibus são extensivos. O EZ-Link card é prático.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Regras Rigorosas", "Singapura tem regras estrictas! Multas por cuspir, mascar pastilha, atravessar na faixa. O sistema de justiça é eficiente.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Custo de Vida", "Singapura é cara! Mas a comida de hawker é acessível (5-10€). Hotéis são caros. Orçamente 100-150€/dia.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Ilhas Adjacentes", "Sentosa é a ilha de lazer com praias e Universal Studios. Pulau Ubin tem natureza selvagem e ciclovia.", R.drawable.icon_cultura)
                )
            }
            22 -> { // Emirados Árabes
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Árabe", "O shawarma, falafel, hummus e kebab são imperdíveis. O camel burger é exótico! Os restaurantes no Dubai Mall são mundiais.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Alta Gastronomia", "Dubai tem restaurantes de chefs estrelados (Gordon Ramsay, Nobu). A experiência de brunch de sexta é lendária!", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Dubai Moderna", "O Burj Khalifa (828m) é o edifício mais alto do mundo. As ilhas Palm Jumeirah e o Dubai Mall são impressionantes.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Abu Dhabi e Tradição", "A Grande Mesquita Sheikh Zayed é inúmerol! O Louvre Abu Dhabi é museu de classe mundial. O património beduíno é preservado.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte no Golfo", "O metro de Dubai é automático e moderno. Os táxis são baratos. As ligações aéreas entre emirados são rápidas.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Ramadão", "Durante o Ramadão, não coma, beba ou fume em público durante o dia. Muitos restaurantes fecham de dia.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Vestuário", "Vista-se modestamente em locais públicos. Roupas justas e de banho são apenas na praia/piscina.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Custo de Vida", "Os Emirados são caros! Hotéis de luxo são caros mas há hotéis económicos. A comida de rua é mais acessível.", R.drawable.icon_cultura)
                )
            }
            23 -> { // Turquia
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Turca", "O kebab (döner, adana, urfa) é famoso! O mezze (pratos pequenos), o baklava e o Turkish breakfast são experiências.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Chá e Café", "O çay (chá de maçã) é везде! O café turco é forte e espesso. O lokum (doce de土耳其) é presente tradicional.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Istambul", "A cidade é ponte entre Europa e Ásia! A Santa Sofia, Palácio Topkapi e Grande Bazar são imperdíveis.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Capadócia", "As formações rochosas e os balões de ar quente são icónicos! Os hoteles em cavernas são experiências únicas.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Interno", "Os voos internos (Turkish Airlines, Pegasus) são económicos. Os ônibus são confortáveis. O metro existe em Istambul.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Barganha", "A barganha é esperada em bazares! Comece em 40% do preço. Sorria e seja paciente.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "História Milenar", "A Turquia tem história de impérios! Gregos, romanos, bizantinos e otomanos deixaram marcas por todo o país.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Hamam", "O banho turco (hamam) é experiência relaxante. Os históricos em Istambul são os mais famosos.", R.drawable.icon_cultura)
                )
            }
            24 -> { // Nova Zelândia
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Neozelandesa", "O lamb (cordeiro) é excelente! Os frutos do mar (lobster, abalone) são frescos. O pavlova é o doce nacional.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Vinhos e Cervejas", "A região de Marlborough produz wines brancos famosos. A cerveja artesanal é vibrante. As vinhas têm paisagens espetaculares.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Terra Média", "A Nova Zelândia é a Terra Média de Tolkien! Os locais de filmagem de O Senhor dos Anéis estão abertos a visitas.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Maori e Cultura", "A cultura Maori é viva! Os hangi (refeições cozidas na terra) e os haka (dança) são experiências culturais únicas.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Explorar a NZ", "Alugar carro é a melhor forma de explorar! As distâncias são longas mas as estradas são boas. As paisagens compensam.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Natureza Preservada", "A NZ protege a natureza! Respeite as trilhas e não perturbe a fauna. O Departamento of Conservation gerencia os parques.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Melhor Época", "O verão (dezembro-fevereiro) é ideal para atividades ao ar livre. O inverno (junho-agosto) é para desportos de neve.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Custo de Vida", "A NZ é cara! Orçamento diário: NZ$100-150 (backpacker), NZ$200+ (conforto). Acampamento é opção económica.", R.drawable.icon_cultura)
                )
            }
            25 -> { // Egito
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Egípcia", "O koshari (lentilhas, massa, arroz) é prato de rua popular! O ful medames (feijões) e o falafel são imperdíveis.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Doces e Chá", "O baklava e o konafa são doces típicos. O chá de hortelã é везде! O café egípcio é forte e doce.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Piramides de Gizé", "As pirâmides são as únicas maravilhas antigas restantes! A Esfinge e o Vale de Gizé são imperdíveis.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Luxor e Valle dos Reis", "Luxor é o maior museu a céu aberto! O Vale dos Reis tem túmulos de faraós, incluindo Tutancâmon.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte no Egito", "O sleeper train conecta Cairo e Luxor. Os voos internos são económicos. Os barcos no Nilo são experiências únicas.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Barganha", "A barganha é essencial em mercados! Comece em 30-40% do preço. Não tenha pressa - faça amigos!", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Segurança", "O Egito é geralmente seguro para turistas. Evite manifestações. Respeite as regras em sítios arqueológicos.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Vestuário em Templos", "Vista-se modestamente - ombros e joelhos cobertos. Isso é especialmente importante em mesquitas.", R.drawable.icon_cultura)
                )
            }
            32 -> { // Marrocos
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Marroquina", "O tagine (guisado lento) é prato nacional! O cuscuz, o pastilla (doce/salgado) e o harira (sopa) são imperdíveis.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Chá e Doces", "O chá de menta com açúcar é tradição! Os doces com amêndoas e mel são viciantes. O café é forte.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Marrakech", "A cidade vermelha tem souks (mercados), a Praça Jemaa el-Fnaa e jardins Majorelle. Perca-se nas ruelas!", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Chefchaouen e Fes", "A cidade azul (Chefchaouen) é instagramável! Fes tem a maior universidade medieval e artesanato tradicional.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Interno", "Os trens conectam principais cidades. Os ônibus (CTM) são confortáveis. Os táxis grand taxi partilham rotas.", R.drawable.icon_transporte),
                    TravelTip(6, "RAJAO", "Rajao - Figura Lendária", "Rajao é uma figura lendária da cultura marroquina, conhecido pela sua sabedoria e histórias tradicionais. É um personagem sábio que aparece em contos populares.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Barganha", "A barganha é esperada! Comece em 30% do preço. Sorria e seja respeitoso. O negócio faz parte da experiência.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Ramadão", "Durante o Ramadão, muitos restaurantes fecham de dia. Respeite o jejum dos locais.", R.drawable.icon_cultura)
                )
            }
            33 -> { // África do Sul
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Braai e Biltong", "O braai (churrasco sul-africano) é tradição! O biltong (carne seca) é lanche típico. O bobotie (carne temperada) é imperdível.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Vinhos Sul-Africanos", "A região de Stellenbosch e Franschhoek produz wines de classe mundial! Os tours por vinhas são experiências.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Cidade do Cabo", "A Table Mountain é icónica! O Cabo da Boa Esperança, os penguins em Boulders Beach e Kirstenbosch são imperdíveis.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Safari e Vida Selvagem", "O Kruger National Park é um dos melhores para safari! Veja os Big Five (leão, leopardo, elefante, rinoceronte, búfalo).", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Interno", "Alugar carro é recomendado para flexibilidade. Os voos internos (FlySafair) são económicos. As estradas são boas.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Segurança", "Algumas zonas têm problemas. Evite áreas de risco à noite. Não deixe pertences visíveis no carro.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Apartheid e História", "Museu do Apartheid em Joanesburgo e Robben Island em Cabo são comoventes mas importantes para entender a história.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Custo de Vida", "A África do Sul é acessível! Orçamento diário: R500-800 (backpacker), R1000+ (conforto). O rand tem boa taxa de câmbio.", R.drawable.icon_cultura)
                )
            }
            28 -> { // Suíça
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Fondue e Raclette", "O fondue (queijo derretido) é prato de inverno! O raclette é outro clássico. O chocolate suíço é mundial.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Culinária Regional", "Cada cantão tem especialidades! O Zürcher Geschnetzeltes (vitela de Zurique) e o Maluns são regionais.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Montanhas e Lagos", "Os Alpes suíços são espetaculares! Jungfrau, Matterhorn e o Lago de Genebra são icónicos. O trenó é experiência única.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Cidades Históricas", "Zurique, Genebra, Berna e Lucerna combinam história e modernidade. Os centros antigos são encantadores.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Swiss Travel System", "O Swiss Travel Pass dá acesso ilimitado a trens, barcos e autocarros. O Swiss Half Fare Card reduz custos pela metade.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Custo de Vida", "A Suíça é cara! Refeições 20-40CHF, hotéis 100-200CHF. Mas a qualidade justifica. Acampamento é opção económica.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Idioma", "O alemão é predominante (suíço-alemão). O francês em Genebra, o italiano no Ticino. O inglês é falado em turismo.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Chocolate e Relojoaria", "A Factory Store Lindt em Zurique e as lojas de relógios são imperdíveis. Qualidade suíça é lendária!", R.drawable.icon_cultura)
                )
            }
            29 -> { // Países Baixos
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Poffertjes e Stroopwafels", "Os poffertjes (panquecas pequenas) são deliciosos! Os stroopwafels (waffles de caramelo) são viciantes.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Queijo Holandês", "O queijo holandês é famoso! Gouda, Edam e Maasdam são imperdíveis. Visite fábricas de queijo em Alkmaar.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Amesterdão", "A cidade tem canais, museus (Rijksmuseum, Van Gogh) e arquitectura única. O Anne Frank Huis é comovente.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Moinhos e Tulipas", "Os moinhos de Kinderdijk são património UNESCO. Os campos de tulipas em Keukenhof (primavera) são espetaculares.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Público", "O NS (NS) conecta todas as cidades. O OV-chipkaart é o cartão de transporte. As bicicletas são everywhere!", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Cultura das Bicicletas", "Alugar bicicleta é a melhor forma de explorar! As ciclovias são everywhere. Respeite as regras de trânsito.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Coffee Shops", "Os coffee shops vendem cannabis legalmente. O turismo de cannabis existe mas esteja informado sobre as leis.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Custo de Vida", "A Holanda é cara mas acessível. Refeições 15-25€, hotéis 80-150€. O Airbnb é alternativa económica.", R.drawable.icon_cultura)
                )
            }
            30 -> { // Grécia
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Culinária Grega", "O moussaka, souvlaki e gyros são imperdíveis! O azeite grego é o melhor do mundo. O iogurte com mel é divino.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Frutos do Mar", "Os peixes e mariscos são frescos! A taverna à beira-mar é experiência obrigatória. O octopus grelhado é delicioso.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Atenas e Acrópole", "A Acrópole e o Partenon são símbolos da civilização ocidental! O Museu da Acrópole é moderno e impressionante.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Ilhas Gregas", "Santorini (pôr do sol), Mykonos (vida noturna), Creta (história) e Paros (autenticidade) são ilhas icónicas.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte nas Ilhas", "As ilhas têm ferry boats. O Hellenic Seaways e Blue Star ligam as ilhas. Voos para ilhas maiores.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Siesta", "Muitos negócios fecham à tarde (14-17h). Planeie suas atividades de manhã e à noite.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Ilhas Menos Turísticas", "Para evitar multidões, visite ilhas como Naxos, Folegandros, Symi ou Sifnos. São autênticas e menos caras.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Custo de Vida", "A Grécia é acessível na Europa. Refeições 10-20€, hotéis 50-100€. As ilhas menores são mais económicas.", R.drawable.icon_cultura)
                )
            }
            31 -> { // Polónia
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Pierogi e Bigos", "Os pierogi (ravioli) são prato nacional! O bigos (guisado de carne) é reconfortante. O żurek (sopa de pão) é imperdível.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Vodka Polaca", "A Polónia é berço da vodka! A Żubrówka (com grama do bisonte) é a mais famosa. Prove as artesanais.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Cracóvia", "A cidade medieval é uma das mais bonitas da Europa! A Praça do Mercado, o Castelo de Wawel e as minas de sal são imperdíveis.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Varsovia e História", "Varsovia foi quase totalmente destruída na WWII. A Cidade Velha foi reconstruída. O Museu do Levantamento é comovente.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Público", "O PKP (comboios) conecta as cidades. Os PKS (ônibus) são económicos. O metro existe apenas em Varsóvia.", R.drawable.icon_transporte),
                    TravelTip(6, "DICAS", "Custo de Vida", "A Polónia é muito acessível! Refeições 5-15€, hotéis 30-70€. É um dos países mais baratos da UE.", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Auschwitz", "A visita a Auschwitz-Birkenau é comovente mas essencial. Reserve com antecedência. É perto de Cracóvia.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Tradições", "A Polónia tem tradições fortes! O Natal (Wigilia) e a Páscoa têm costumes únicos. A hospitalidade é valorizada.", R.drawable.icon_cultura)
                )
            }
            32 -> { // Brasil (já coberto, mas preciso de ID único)
                listOf(
                    TravelTip(1, "GASTRONOMIA", "Feijoada e Churrasco", "A feijoada completa com arroz, couve, laranja e cachaça é o prato nacional. O churrasco sulista (gaucho) é reconhecido mundialmente.", R.drawable.icon_comida),
                    TravelTip(2, "GASTRONOMIA", "Culinária Regional", "O acarajé e vatapá da Bahia, a moqueca capixaba, o barreado do Paraná e a pizza de São Paulo são especialidades regionais imperdíveis.", R.drawable.icon_comida),
                    TravelTip(3, "CULTURA", "Carnaval", "O Carnaval do Rio é o maior do mundo! Os desfiles na Sapucaí são espetaculares. O Carnaval de Salvador e Recife também são famosos.", R.drawable.icon_cultura),
                    TravelTip(4, "CULTURA", "Praias e Natureza", "O Brasil tem 7.500 km de costa. Fernando de Noronha, Jericoacoara, Lopes Mendes (Ilha Grande) e as praias de Fernando de Noronha são paradisíacas.", R.drawable.icon_cultura),
                    TravelTip(5, "TRANSPORTE", "Transporte Interno", "As distâncias são enormes! Use voos para longas distâncias (Latam, Gol, Azul). Em cidades, use Uber ou 99. O metrô existe em SP, Rio, BH e Salvador.", R.drawable.icon_transporte),
                    TravelTip(6, "PESSOAS", "Figuras Importantes", "Pelé (futebol), Ayrton Senna (F1), Carmen Miranda (cantora), Machado de Assis (escritor), Oscar Niemeyer (arquiteto), Neymar (futebol).", R.drawable.icon_cultura),
                    TravelTip(7, "DICAS", "Segurança", "Evite áreas de risco à noite. Não use joias ou objetos de valor nas praias. Mantenha documentos seguros. Em caso de emergência, disque 190.", R.drawable.icon_cultura),
                    TravelTip(8, "DICAS", "Idioma e Comunicação", "O português brasileiro é diferente do europeu. O inglês é falado em hotéis e restaurantes turísticos. Aprenda algumas frases básicas!", R.drawable.icon_cultura)
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
