# 🌍 App de Dicas de Viagem por País

## 🎯 Objetivo do Projeto
Aplicação Android que funciona como um guia de viagens digital, onde o utilizador pode selecionar um país e receber dicas específicas sobre cultura, comida, transporte e muito mais.

## ⚙️ Requisitos Técnicos
- **Linguagem**: Kotlin
- **Interface**: XML (Android Views)
- **Arquitetura**: Activities separadas com RecyclerView
- **Navegação**: Intents entre ecrãs

## 📱 Funcionalidades
1. **Ecrã Principal (MainActivity)**
   - Lista de países com bandeiras e informações básicas
   - Cada item mostra nome, capital, moeda e continente
   - Design moderno com cards clicáveis

2. **Ecrã de Dicas (CountryTipsActivity)**
   - Header com informações detalhadas do país
   - Lista de dicas organizadas por categorias
   - Ícones visuais para cada tipo de dica

## � Países Incluídos
1. **🇵🇹 Portugal** - Gastronomia, Fado, Transporte, Azulejos
2. **🇪🇸 Espanha** - Tapas, Flamenco, AVE, Gaudí
3. **🇫🇷 França** - Cozinha Francesa, Museus, Metrô, Vinhos

## 🎨 Design
- **Cores**: Azul (#2196F3), branco, cinzentos
- **Estilo**: Moderno, limpo e intuitivo
- **Componentes**: CardView para itens, NestedScrollView para detalhes
- **Tipografia**: Sans-serif com hierarquia clara

## 🧱 Estrutura do Projeto
```
app/src/main/java/com/example/travelguide/
├── MainActivity.kt           - Ecrã principal com lista
├── DetailActivity.kt         - Ecrã de detalhes
├── TouristPlace.kt          - Modelo de dados
└── TouristPlaceAdapter.kt   - Adapter para RecyclerView

app/src/main/res/
├── layout/
│   ├── activity_main.xml           - Layout principal
│   ├── activity_detail.xml         - Layout detalhes
│   └── item_tourist_place.xml      - Item da lista
├── drawable/                       - Imagens vetoriais dos locais
├── values/
│   ├── colors.xml                  - Cores do tema
│   └── styles.xml                  - Estilos reutilizáveis
└── AndroidManifest.xml             - Configurações da app
```

## 🚀 Como Executar
1. Abra o projeto no Android Studio
2. Sincronize as dependências (Gradle)
3. Execute em um emulador ou dispositivo físico
4. A aplicação está pronta para usar!

## 🔧 Dependências Principais
- AndroidX RecyclerView
- AndroidX CardView
- Material Design Components
- ConstraintLayout

## 📋 Requisitos Mínimos
- Android API 24 (Android 7.0) ou superior
- Kotlin suportado

## ✨ Funcionalidades Extras
- Animação de transição entre ecrãs
- Scroll suave na lista
- Design responsivo
- Navegação intuitiva com botão voltar

---

**Projeto desenvolvido como exemplo de aplicação Android completa em Kotlin** 🇵🇹
