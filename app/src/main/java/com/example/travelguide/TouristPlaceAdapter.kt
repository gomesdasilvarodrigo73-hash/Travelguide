package com.example.travelguide

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TouristPlaceAdapter(
    private val context: Context,
    private val touristPlaces: List<TouristPlace>
) : RecyclerView.Adapter<TouristPlaceAdapter.TouristPlaceViewHolder>() {

    class TouristPlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.placeImage)
        val nameTextView: TextView = itemView.findViewById(R.id.placeName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TouristPlaceViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_tourist_place, parent, false)
        return TouristPlaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: TouristPlaceViewHolder, position: Int) {
        val touristPlace = touristPlaces[position]
        holder.imageView.setImageResource(touristPlace.imageRes)
        holder.nameTextView.text = touristPlace.name

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("tourist_place", touristPlace)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = touristPlaces.size
}
