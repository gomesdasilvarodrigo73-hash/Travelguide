package com.example.travelguide

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailImage: ImageView = findViewById(R.id.detailImage)
        val detailName: TextView = findViewById(R.id.detailName)
        val detailDescription: TextView = findViewById(R.id.detailDescription)
        val detailLocation: TextView = findViewById(R.id.detailLocation)
        val detailCuriosities: TextView = findViewById(R.id.detailCuriosities)

        val touristPlace = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("tourist_place", TouristPlace::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("tourist_place") as? TouristPlace
        }

        touristPlace?.let {
            detailImage.setImageResource(it.imageRes)
            detailName.text = it.name
            detailDescription.text = it.description
            detailLocation.text = "📍 ${it.location}"
            detailCuriosities.text = it.curiosities
            
            // Definir o título da ActionBar
            supportActionBar?.title = it.name
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
