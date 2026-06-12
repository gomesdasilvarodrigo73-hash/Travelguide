# 🌍 Travalguide - Guia de Viagem Android

## 🎯 Sobre a App
Aplicação Android completa em Kotlin que funciona como um guia de viagens digital, com dicas detalhadas para 33 países em 5 continentes.

## ⚙️ Requisitos Técnicos
- **Linguagem**: Kotlin
- **Interface**: XML (Android Views)
- **Arquitetura**: Activities separadas com RecyclerView
- **Navegação**: Intents entre ecrãs
- **Persistência**: SharedPreferences para utilizadores

## 📱 Funcionalidades

### 1. Sistema de Login/Registo
- Registo de utilizadores com nome, email, username e password
- Login com validação
- Utilizador admin automático (admin/1234)
- Botão de navegação para voltar

### 2. Ecrã Principal (MainActivity)
- Lista de 33 países com bandeiras vector
- Informação: Nome, Capital, Moeda, Continente
- Botão "Ver +" para acessar dicas
- Design moderno com cards e gradientes

### 3. Ecrã de Dicas (CountryTipsActivity)
- Header com informações do país
- 8 dicas por país organizadas por categorias:
  - **GASTRONOMIA**: Pratos típicos, bebidas locais
  - **CULTURA**: Monumentos, museus, tradições
  - **TRANSPORTE**: Como se locomover no país
  - **DICAS**: Segurança, idioma, moeda, gorjetas
  - **PESSOAS**: Figuras importantes (exceto Marrocos)
  - **RAJAO**: Categoria especial em Marrocos
- Ícones visuais para cada categoria
- Toolbar com botão de navegação

## 🌍 Países Disponíveis (33)

### Europa (12)
🇵🇹 Portugal | 🇪🇸 Espanha | 🇫🇷 França | 🇮🇹 Itália | 🇩🇪 Alemanha | 🇬🇧 Reino Unido
🇨🇭 Suíça | 🇳🇱 Países Baixos | ��🇪 Bélgica | �🇹 Áustria | 🇬🇷 Grécia | 🇵🇱 Polónia

### Américas (8)
🇧🇷 Brasil | 🇺🇸 Estados Unidos | 🇨🇦 Canadá | 🇲🇽 México | 🇦🇷 Argentina | 🇨🇱 Chile
🇨🇴 Colômbia | 🇵🇪 Peru

### Ásia (8)
🇯🇵 Japão | 🇨🇳 China | �🇷 Coreia do Sul | 🇮🇳 Índia | 🇹🇭 Tailândia | 🇸🇬 Singapura
🇦🇪 Emirados Árabes | 🇹🇷 Turquía

### Oceania (2)
🇦🇺 Austrália | 🇳🇿 Nova Zelândia

### África (3)
🇪🇬 Egito | 🇲🇦 Marrocos | 🇿🇦 África do Sul

## 🎨 Design
- **Cores**:
  - Primary Blue: #00d9ff
  - Primary Green: #00ff88
  - Background Dark: #1a1a2e
  - Card Background: #2a2a4a
  - Text Primary: #ffffff
  - Text Secondary: #a0a0a0
- **Estilo**: Moderno, gradientes, Material Design
- **Componentes**: CardView, MaterialButton, Toolbar
- **Tipografia**: Poppins (Google Fonts)

## 🧱 Estrutura do Projeto
```
app/src/main/java/com/example/travelguide/
├── MainActivity.kt           - Ecrã principal com lista de países
├── CountryTipsActivity.kt    - Ecrã de dicas do país
├── LoginActivity.kt          - Ecrã de login
├── RegisterActivity.kt       - Ecrã de registo
├── CountryAdapter.kt         - Adapter da lista de países
├── TravelTipAdapter.kt       - Adapter das dicas
├── Country.kt                - Data class do país
└── TravelTip.kt              - Data class da dica

app/src/main/res/
├── layout/
│   ├── activity_main.xml           - Layout principal
│   ├── activity_country_tips.xml   - Layout de dicas
│   ├── activity_login.xml          - Layout de login
│   ├── activity_register.xml       - Layout de registo
│   ├── item_country.xml             - Item da lista de países
│   └── item_travel_tip.xml          - Item da lista de dicas
├── drawable/
│   ├── flag_*.xml                  - 33 bandeiras vector
│   ├── icon_*.xml                  - Ícones de categorias
│   ├── bg_gradient.xml             - Gradiente de fundo
│   └── bg_card.xml                 - Fundo dos cards
├── values/
│   ├── colors.xml                  - Cores do tema
│   └── strings.xml                 - Strings da app
└── AndroidManifest.xml             - Configurações da app
```

## 🚀 Como Executar
1. Abra o projeto no Android Studio
2. Sincronize as dependências (Gradle)
3. Execute em um emulador ou dispositivo físico (Android 7.0+)
4. Faça login com:
   - Utilizador: `admin`
   - Password: `1234`
5. Ou registe um novo utilizador

## 📥 Download da App
- **APK**: https://github.com/gomesdasilvarodrigo73-hash/Travelguide/raw/main/releases/app-debug.apk
- **Website**: https://gomesdasilvarodrigo73-hash.github.io/Travelguide/

## 🔧 Dependências Principais
- AndroidX RecyclerView
- AndroidX CardView
- Material Design Components
- ConstraintLayout

## 📋 Requisitos Mínimos
- Android API 24 (Android 7.0) ou superior
- Kotlin 1.9+

## ✨ Destaques
- **264 dicas de viagem** (8 × 33 países)
- **33 bandeiras vector** em XML
- **Sistema de utilizadores** completo
- **Website online** com download
- **Design moderno** com gradientes
- **Rajao** como figura lendária em Marrocos

---

**Projeto desenvolvido como exemplo de aplicação Android completa em Kotlin** 🇵🇹
