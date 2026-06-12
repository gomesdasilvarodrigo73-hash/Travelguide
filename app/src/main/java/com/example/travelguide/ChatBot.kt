package com.example.travelguide

object ChatBot {

    private val countryMap = mapOf(
        1 to Country(1, "Portugal", R.drawable.flag_portugal, "Europa", "🇵🇹", "Lisboa", "EUR", "Português", "Mar–Out", 2),
        2 to Country(2, "Espanha", R.drawable.flag_espanha, "Europa", "🇪🇸", "Madrid", "EUR", "Espanhol", "Mar–Jun", 2),
        3 to Country(3, "França", R.drawable.flag_franca, "Europa", "🇫🇷", "Paris", "EUR", "Francês", "Abr–Jun", 3),
        4 to Country(4, "Itália", R.drawable.flag_italia, "Europa", "🇮🇹", "Roma", "EUR", "Italiano", "Abr–Jun", 3),
        5 to Country(5, "Alemanha", R.drawable.flag_alemanha, "Europa", "🇩🇪", "Berlim", "EUR", "Alemão", "Mai–Set", 3),
        6 to Country(6, "Reino Unido", R.drawable.flag_uk, "Europa", "🇬🇧", "Londres", "GBP", "Inglês", "Abr–Set", 3),
        7 to Country(7, "Suíça", R.drawable.flag_suica, "Europa", "🇨🇭", "Berna", "CHF", "Alemão", "Jun–Set", 3),
        8 to Country(8, "Países Baixos", R.drawable.flag_holanda, "Europa", "🇳🇱", "Amesterdão", "EUR", "Holandês", "Abr–Set", 3),
        9 to Country(9, "Bélgica", R.drawable.flag_belgica, "Europa", "🇧🇪", "Bruxelas", "EUR", "Holandês/Francês", "Mai–Set", 2),
        10 to Country(10, "Áustria", R.drawable.flag_austria, "Europa", "🇦🇹", "Viena", "EUR", "Alemão", "Mai–Set", 3),
        11 to Country(11, "Grécia", R.drawable.flag_grecia, "Europa", "🇬🇷", "Atenas", "EUR", "Grego", "Abr–Out", 2),
        12 to Country(12, "Polónia", R.drawable.flag_polonia, "Europa", "🇵🇱", "Varsóvia", "PLN", "Polaco", "Mai–Set", 1),
        13 to Country(13, "Irlanda", R.drawable.flag_irlanda, "Europa", "🇮🇪", "Dublin", "EUR", "Inglês", "Mai–Set", 3),
        14 to Country(14, "Czech Republic", R.drawable.flag_checia, "Europa", "🇨🇿", "Praga", "CZK", "Checo", "Abr–Set", 1),
        15 to Country(15, "Roménia", R.drawable.flag_romenia, "Europa", "🇷🇴", "Bucareste", "RON", "Romeno", "Mai–Set", 1),
        16 to Country(16, "Hungria", R.drawable.flag_hungria, "Europa", "🇭🇺", "Budapeste", "HUF", "Húngaro", "Mai–Set", 1),
        17 to Country(17, "Bulgária", R.drawable.flag_bulgaria, "Europa", "🇧🇬", "Sofia", "BGN", "Búlgaro", "Mai–Set", 1),
        18 to Country(18, "Croácia", R.drawable.flag_croacia, "Europa", "🇭🇷", "Zagrebe", "EUR", "Croata", "Mai–Set", 2),
        19 to Country(19, "Sérbia", R.drawable.flag_serbia, "Europa", "🇷🇸", "Belgrado", "RSD", "Sérvio", "Abr–Out", 1),
        20 to Country(20, "Suécia", R.drawable.flag_suecia, "Europa", "🇸🇪", "Estocolmo", "SEK", "Sueco", "Mai–Set", 3),
        21 to Country(21, "Noruega", R.drawable.flag_noruega, "Europa", "🇳🇴", "Oslo", "NOK", "Norueguês", "Jun–Set", 3),
        22 to Country(22, "Dinamarca", R.drawable.flag_dinamarca, "Europa", "🇩🇰", "Copenhaga", "DKK", "Dinamarquês", "Mai–Set", 3),
        23 to Country(23, "Finlândia", R.drawable.flag_finlandia, "Europa", "🇫🇮", "Helsínquia", "EUR", "Finlandês", "Jun–Set", 3),
        24 to Country(24, "Islândia", R.drawable.flag_islandia, "Europa", "🇮🇸", "Reiquiavik", "ISK", "Islandês", "Jun–Set", 2),
        25 to Country(25, "Moldávia", R.drawable.flag_moldavia, "Europa", "🇲🇩", "Chișinău", "MDL", "Romeno", "Abr–Jun", 1),
        26 to Country(26, "Quénia", R.drawable.flag_kenya, "África", "🇰🇪", "Nairóbi", "KES", "Inglês/Suaíli", "Jul–Out", 1),
        27 to Country(27, "Etiópia", R.drawable.flag_etiopia, "África", "🇪🇹", "Adis Abeba", "ETB", "Amárico", "Nov–Jan", 1),
        28 to Country(28, "Tanzânia", R.drawable.flag_tanzania, "África", "🇹🇿", "Dodoma", "TZS", "Suaíli/Inglês", "Jun–Oct", 2),
        29 to Country(29, "Nigéria", R.drawable.flag_nigeria, "África", "🇳🇬", "Abuja", "NGN", "Inglês", "Nov–Mar", 1),
        30 to Country(30, "Gana", R.drawable.flag_ghana, "África", "🇬🇭", "Acra", "GHS", "Inglês", "Nov–Mar", 1),
        31 to Country(31, "Senegal", R.drawable.flag_senegal, "África", "🇸🇳", "Dakar", "XOF", "Francês", "Nov–Mar", 1),
        32 to Country(32, "Camarões", R.drawable.flag_camaroes, "África", "🇨🇲", "Yaoundé", "XAF", "Francês/Inglês", "Dec–Feb", 1),
        33 to Country(33, "Tunísia", R.drawable.flag_tunisia, "África", "🇹🇳", "Túnis", "TND", "Árabe", "Mar–Mai", 1),
        34 to Country(34, "Egito", R.drawable.flag_egito, "África", "🇪🇬", "Cairo", "EGP", "Árabe", "Out–Abr", 1),
        35 to Country(35, "Marrocos", R.drawable.flag_marrocos, "África", "🇲🇦", "Rabat", "MAD", "Árabe", "Mar–Mai", 1),
        36 to Country(36, "África do Sul", R.drawable.flag_south_africa, "África", "🇿🇦", "Pretória", "ZAR", "Inglês", "Abr–Set", 2),
        37 to Country(37, "Cuba", R.drawable.flag_cuba, "América Central", "🇨🇺", "Havana", "CUP", "Espanhol", "Nov–Abr", 2),
        38 to Country(38, "Rep. Dominicana", R.drawable.flag_repub_dom, "América Central", "🇩🇴", "Santo Domingo", "DOP", "Espanhol", "Dic–Abr", 2),
        39 to Country(39, "Jamaica", R.drawable.flag_jamaica, "América Central", "🇯🇲", "Kingston", "JMD", "Inglês", "Nov–Abr", 2),
        40 to Country(40, "Costa Rica", R.drawable.flag_costa_rica, "América Central", "🇨🇷", "San José", "CRC", "Espanhol", "Dic–Abr", 2),
        41 to Country(41, "Panamá", R.drawable.flag_panama, "América Central", "🇵🇦", "Cidade do Panamá", "PAB", "Espanhol", "Jan–Abr", 2),
        42 to Country(42, "Guatemala", R.drawable.flag_guatemala, "América Central", "🇬🇹", "Guatemala", "GTQ", "Espanhol", "Nov–Abr", 1),
        43 to Country(43, "Japão", R.drawable.flag_japao, "Ásia", "🇯🇵", "Tóquio", "JPY", "Japonês", "Mar–Mai", 3),
        44 to Country(44, "China", R.drawable.flag_china, "Ásia", "🇨🇳", "Pequim", "CNY", "Mandarim", "Abr–Jun", 2),
        45 to Country(45, "Coreia do Sul", R.drawable.flag_coreia, "Ásia", "🇰🇷", "Seul", "KRW", "Coreano", "Abr–Jun", 2),
        46 to Country(46, "Índia", R.drawable.flag_india, "Ásia", "🇮🇳", "Nova Délhi", "INR", "Hindi/Inglês", "Out–Mar", 1),
        47 to Country(47, "Tailândia", R.drawable.flag_tailandia, "Ásia", "🇹🇭", "Bangkok", "THB", "Tailandês", "Nov–Mar", 1),
        48 to Country(48, "Singapura", R.drawable.flag_singapura, "Ásia", "🇸🇬", "Singapura", "SGD", "Inglês", "Jan–Mar", 3),
        49 to Country(49, "Emirados Árabes", R.drawable.flag_uae, "Ásia", "🇦🇪", "Abu Dhabi", "AED", "Árabe", "Nov–Mar", 3),
        50 to Country(50, "Turquia", R.drawable.flag_turquia, "Ásia/Europa", "🇹🇷", "Ancara", "TRY", "Turco", "Apr–Jun", 2),
        51 to Country(51, "Vietnã", R.drawable.flag_vietnao, "Ásia", "🇻🇳", "Hanói", "VND", "Vietnamita", "Feb–Apr", 1),
        52 to Country(52, "Malásia", R.drawable.flag_malasia, "Ásia", "🇲🇾", "Kuala Lumpur", "MYR", "Malaio", "Dez–Mar", 1),
        53 to Country(53, "Indonésia", R.drawable.flag_indonesia, "Ásia", "🇮🇩", "Jacarta", "IDR", "Indonésio", "Mai–Set", 1),
        54 to Country(54, "Filipinas", R.drawable.flag_filipinas, "Ásia", "🇵🇭", "Manila", "PHP", "Filipino/Inglês", "Nov-Apr", 1),
        55 to Country(55, "Nepal", R.drawable.flag_nepal, "Ásia", "🇳🇵", "Katmandu", "NPR", "Nepalês", "Out–Mar", 1),
        56 to Country(56, "Sri Lanka", R.drawable.flag_srilanka, "Ásia", "🇱🇰", "Colombo", "LKR", "Cingalês/Tamil", "Jan–Mar", 1),
        57 to Country(57, "Israel", R.drawable.flag_israel, "Ásia", "🇮🇱", "Jerusalém", "ILS", "Hebraico/Árabe", "Out–Abr", 3),
        58 to Country(58, "Arábia Saudita", R.drawable.flag_arabia, "Ásia", "🇸🇦", "Riyad", "SAR", "Árabe", "Nov–Mar", 3),
        59 to Country(59, "Austrália", R.drawable.flag_australia, "Oceania", "🇦🇺", "Canberra", "AUD", "Inglês", "Set–Nov", 3),
        60 to Country(60, "Nova Zelândia", R.drawable.flag_nz, "Oceania", "🇳🇿", "Wellington", "NZD", "Inglês", "Out–Mar", 3),
    )

    fun getWelcomeMessage(): String =
        """Olá! 👋 Sou o assistente de viagem da TravelGuide.
           |Posso ajudar a escolher o destino ideal para si!
           |
           |Experimente perguntar:
           |• "Quais são os países mais baratos?"
           |• "Quero um destino de sol e praia"
           |• "Dicas para visitar Portugal"
           |• "Melhor época para ir ao Japão"
           |• "Países com boa segurança"
           |• "Destinos para romantismo"
           |
           |Estou aqui para ajudar! 🌍""".trimMargin("|")

    fun getQuickSuggestions(): List<String> = listOf(
        "💰 Países mais baratos",
        "☀️ Destinos de sol e praia",
        "🌸 Destinos românticos",
        "🛡️ Países seguros",
        "🗓️ Melhores épocas para viajar"
    )

    fun getResponse(input: String): String {
        val lowerInput = input.lowercase().trim()

        // Welcome
        if (lowerInput.isEmpty() || matchesPatterns(lowerInput, listOf("oi", "ola", "olá", "hi", "hey", "hello"))) {
            return "Olá! 😊 Como posso ajudar a planear a sua próxima viagem? Pode perguntar sobre destinos, preços, clima, segurança, ou qualquer dúvida de viagem!"
        }

        // Budget recommendations
        if (matchesPatterns(lowerInput, listOf("barato", "económ", "economi", "custo", "preço", "price", "cheap", "budget", "econo"))) {
            val budgetCountries = countryMap.values.filter { it.budgetLevel == 1 }.sortedBy { it.name }
            val moderateCountries = countryMap.values.filter { it.budgetLevel == 2 }.sortedBy { it.name }
            return buildString {
                append("💰 **Países mais económicos:**\n")
                budgetCountries.forEach {
                    append("  • ${it.continentEmoji} ${it.name} (${it.continent})\n")
                }
                append("\n🔶 **Preço moderado:**\n")
                moderateCountries.forEach {
                    append("  • ${it.continentEmoji} ${it.name}\n")
                }
                append("\n💡 A maioria dos países da Europa de Leste, Ásia e África oferecem ótimas experiências por preços acessíveis.")
            }
        }

        // Sol and praia / beach destinations
        if (matchesPatterns(lowerInput, listOf("sol", "praia", "praía", "beach", "sun", "tropical", "quente", "clima", "weather", "verão", "verao"))) {
            return """☀️ **Destinos de sol e praia:**
  • 🇹🇳 Tunísia - Melhor época: Mar–Mai
  • 🇪🇬 Egito - Melhor época: Out–Abr
  • 🇲🇦 Marrocos - Melhor época: Mar–Mai
  • 🇹🇭 Tailândia - Melhor época: Nov–Mar
  • 🇻🇳 Vietnã - Melhor época: Feb–Apr
  • 🇹🇷 Turquia - Melhor época: Apr–Jun
  • 🇬🇷 Grécia - Melhor época: Abr–Out
  • 🇭🇷 Croácia - Melhor época: Mai–Set
  • 🇨🇺 Cuba - Melhor época: Nov–Abr
  • 🇩🇴 Rep. Dominicana - Melhor época: Dic–Abr
  • 🇦🇺 Austrália - Melhor época: Set–Nov
  • 🇱🇰 Sri Lanka - Melhor época: Jan–Mar

💡 Recomendo a época indicada para cada destino para evitar chuvas!"""
        }

        // Romantic destinations
        if (matchesPatterns(lowerInput, listOf("românt", "romant", "romance", "parel", "casal", "lua de mel", "honeymoon", "love"))) {
            return """🌹 **Destinos românticos:**
  • 🇬🇷 Grécia (Santorini - pôr do sol lendário)
  • 🇮🇹 Itália (Veneza, Amalfi, Toscana)
  • 🇫🇷 França (Paris - Cidade do Amor)
  • 🇲🇦 Marrocos (palácios e desertos)
  • 🇹🇭 Tailândia (praias paradisíacas)
  • 🇮🇸 Islândia (aurora boreal)
  • 🇵🇹 Portugal (Douro Valley, Algarve)
  • 🇸🇬 Singapura (jardins futurísticos)

💡 **Dica:** A baixa temporada geralmente oferece preços mais baixos e menos turistas!"""
        }

        // Safety
        if (matchesPatterns(lowerInput, listOf("segurança", "seguro", "segura", "safe", "security", "danger", "perigo"))) {
            return """🛡️ **Destinos considerados seguros:**
  • 🇨🇭 Suíça
  • 🇦🇺 Austrália
  • 🇳🇴 Noruega
  • 🇫🇮 Finlândia
  • 🇮🇪 Irlanda
  • 🇯🇵 Japão
  • 🇸🇬 Singapura
  • 🇦🇪 Emirados Árabes

💡 A maioria dos países na nossa lista é considerada segura para turistas. Consulte sempre as recomendações do MNE antes de viajar!"""
        }

        // Best season / época
        if (matchesPatterns(lowerInput, listOf("melhor", "epoca", "quando", "when", "temporada", "season"))) {
            val spring = countryMap.values.filter { it.bestSeason.contains("Abr") || it.bestSeason.contains("Mar") || it.bestSeason.contains("Mai") }.take(5)
            val summer = countryMap.values.filter { it.bestSeason.contains("Jun") || it.bestSeason.contains("Jul") || it.bestSeason.contains("Ago") || it.bestSeason.contains("Set") }.take(5)
            val fall = countryMap.values.filter { it.bestSeason.contains("Out") || it.bestSeason.contains("Nov") || it.bestSeason.contains("Dez") }.take(5)
            val winter = countryMap.values.filter { it.bestSeason.contains("Jan") || it.bestSeason.contains("Fev") }.take(5)
            return buildString {
                append("🗓️ **Melhores épocas para viajar:**\n\n")
                append("🌸 **Primavera (Mar-Mai):**\n")
                spring.forEach { append("  • ${it.continentEmoji} ${it.name} (Época ideal: ${it.bestSeason})\n") }
                append("\n☀️ **Verão (Jun-Set):**\n")
                summer.forEach { append("  • ${it.continentEmoji} ${it.name}\n") }
                append("\n🍂 **Outono (Out-Dez):**\n")
                fall.forEach { append("  • ${it.continentEmoji} ${it.name}\n") }
                append("\n❄️ **Inverno (Dez-Fev):**\n")
                winter.forEach { append("  • ${it.continentEmoji} ${it.name}\n") }
                append("\n💡 Cada estação tem os seus benefícios! A primavera e outono costumam ter menos turistas.")
            }
        }

        // Specific country
        val matchedCountry = findCountryByName(lowerInput)
        if (matchedCountry != null) {
            return getCountryInfo(matchedCountry)
        }

        // General travel tips
        if (matchesPatterns(lowerInput, listOf("dica", "tip", "conse", "dicas", "conselho", "sugest", "ajud", "help", "what", "como"))) {
            return """📋 **Dicas gerais de viagem:**
  1. 📄 **Documentos:** Passaporte válido por 6+ meses e vistos quando necessários
  2. 🏥 **Seguro viagem:** Imprescindível! Cobre emergências médicas
  3. 💳 **Dinheiro:** Misture cartões, dinheiro local e cartões de crédito
  4. 📱 **Comunicação:** E-SIM local ou roaming internacional
  5. 🧳 **Mala:** Leve o essencial, roupas em camadas
  6. 🗺️ **Apps úteis:** Maps, Google Translate, Uber, Booking
  7. 🤝 **Respeito cultural:** Aprenda frases locais e costumes
  8. 🏥 **Vacinas:** Consulte um centro de vacinação 4-6 semanas antes

💡 Quer dicas específicas para algum destino? Pergunte-me! 😊"""
        }

        // Continents
        if (matchesPatterns(lowerInput, listOf("europe", "europa"))) {
            val europe = countryMap.values.filter { it.continent.contains("Europa") }
            return buildString {
                append("🇪🇺 **Países Europeus disponíveis:**\n")
                europe.forEach { append("  • ${it.continentEmoji} ${it.name}  ") }
                append("\n\n💡 Europa é ótima para quem quer explorar vários países de forma compacta!")
            }
        }

        if (matchesPatterns(lowerInput, listOf("asia"))) {
            val asia = countryMap.values.filter { it.continent.contains("Ásia") }
            return buildString {
                append("🌏 **Destinos Asiáticos:**\n")
                asia.forEach { append("  • ${it.continentEmoji} ${it.name}  ") }
                append("\n\n💡 A Ásia oferece a melhor relação qualidade-preço! 🤑")
            }
        }

        if (matchesPatterns(lowerInput, listOf("áfrica", "africa"))) {
            val africa = countryMap.values.filter { it.continent.contains("África") }
            return buildString {
                append("🌍 **Destinos Africanos:**\n")
                africa.forEach { append("  • ${it.continentEmoji} ${it.name}  ") }
                append("\n\n💡 África oferece experiências únicas de safári, cultura e aventura! 🦁")
            }
        }

        if (matchesPatterns(lowerInput, listOf("américa", "america", "centr"))) {
            val americas = countryMap.values.filter { it.continent.contains("América") }
            return buildString {
                append("🌎 **Destinos nas Américas:**\n")
                americas.forEach { append("  • ${it.continentEmoji} ${it.name}  ") }
                append("\n\n💡 América Central é perfeita para quem busca sol, praias e preços acessíveis! 🏖️")
            }
        }

        if (matchesPatterns(lowerInput, listOf("ociania", "oceania"))) {
            return """🌊 **Oceania:**
  • 🇦🇺 Austrália - Grande Barreira de Corais, Sydney, Melbourne
  • 🇳🇿 Nova Zelândia - Milford Sound, Hobbiton, Natureza virgem

💡 Para uma aventura incrível e paisagens incríveis! 🏔️"""
        }

        // Default: friendly fallback
        return """🤔 Não percebi completamente a sua pergunta, mas estou aqui para ajudar!

Posso responder a perguntas sobre:
  • 💰 **Preços e orçamento** - países baratos ou luxuosos
  • ☀️ **Clima e praias** - destinos de sol e praia
  • 🌹 **Romantismo** - destinos para casais
  • 🛡️ **Segurança** - países mais seguros
  • 🗓️ **Melhores épocas** - quando viajar
  • 📋 **Dicas gerais** de viagem
  • 📍 **Informação sobre países** específicos

Pode-me dizer que tipo de viagem pretende? 😊"""
    }

    private fun findCountryByName(input: String): Country? {
        val aliases = mapOf(
            "portugal" to 1, "espanha" to 2, "espania" to 2, "franca" to 3, "frança" to 3,
            "italia" to 4, "alemanha" to 5, "alemaha" to 5, "almanha" to 5,
            "reino unido" to 6, "inglaterra" to 6, "londres" to 6,
            "suiça" to 7, "suica" to 7, "holanda" to 8, "amsterdam" to 8,
            "belgica" to 9, "bruxelas" to 9,
            "austria" to 10, "áustria" to 10, "viena" to 10,
            "gre" to 11, "grecia" to 11, "atens" to 11,
            "polonia" to 12, "polónia" to 12, "varsóvia" to 12,
            "irlanda" to 13, "dublin" to 13,
            "czech" to 14, "praga" to 14,
            "romenia" to 15, "roménia" to 15, "bucareste" to 15,
            "hungria" to 16, "budapeste" to 16,
            "bulgaria" to 17, "bulgária" to 17, "sofia" to 17,
            "croacia" to 18, "croácia" to 18, "zagrebe" to 18,
            "serbia" to 19, "sérbia" to 19, "belgrado" to 19,
            "suecia" to 20, "estocolmo" to 20,
            "noruega" to 21, "oslo" to 21,
            "dinamarca" to 22, "copenhaga" to 22,
            "finlandia" to 23, "finlândia" to 23, "helsinqui" to 23,
            "islandia" to 24, "islanda" to 24, "reiquiavik" to 24,
            "moldavia" to 25, "moldávia" to 25,
            "kenia" to 26, "quénia" to 26, "nairobi" to 26,
            "etiopia" to 27, "etiópia" to 27,
            "tanzania" to 28, "tanzânia" to 28,
            "nigéria" to 29, "nigeria" to 29,
            "ghana" to 30, "senegal" to 31,
            "camaroes" to 32, "camarões" to 32,
            "tunisia" to 33, "tunísia" to 33,
            "egito" to 34, "marrocos" to 35,
            "africa do sul" to 36, "afrika do sul" to 36,
            "cuba" to 37, "dominica" to 38, "república dominicana" to 38,
            "jamaica" to 39, "costa rica" to 40, "panama" to 41, "guatemala" to 42,
            "japao" to 43, "japão" to 43, "tokyo" to 43,
            "pequim" to 44, "china" to 44,
            "coreia" to 45, "seul" to 45,
            "india" to 46, "índia" to 46,
            "thailand" to 47, "tailandia" to 47, "bangkok" to 47,
            "singapura" to 48, "singapur" to 48,
            "uae" to 49, "abu dhabi" to 49,
            "turquia" to 50, "ankara" to 50, "istanbul" to 50,
            "vietnam" to 51,
            "malasia" to 52, "indonesia" to 53,
            "filipinas" to 54, "nepal" to 55,
            "sri lanka" to 56, "israel" to 57,
            "arabia" to 58, "arabia saudita" to 58,
            "australia" to 59, "austrália" to 59, "canberra" to 59,
            "nova zelândia" to 60, "wellington" to 60, "new zealand" to 60
        )

        for ((alias, id) in aliases) {
            if (input.contains(alias)) {
                return countryMap[id]
            }
        }
        return null
    }

    private fun getCountryInfo(country: Country): String {
        val budgetText = when (country.budgetLevel) {
            1 -> "💰 Económico"
            2 -> "💰💰 Moderado"
            3 -> "💰💰💰 Luxuoso"
            else -> ""
        }
        return """📍 **${country.name}** ${country.continentEmoji}
  📌 Capital: ${country.capital}
  💱 Moeda: ${country.currency}
  🗣️ Idioma: ${country.language}
  🌡️ Melhor época: ${country.bestSeason}
  $budgetText
  🌏 Continente: ${country.continent}

💡 Quer mais dicas sobre ${country.name}? Posso partilhar informações sobre cultura, gastronomia, transportes e muito mais!"""
    }

    private fun matchesPatterns(input: String, patterns: List<String>): Boolean {
        return patterns.any { input.contains(it, ignoreCase = true) }
    }
}
