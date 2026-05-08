package com.example.travelguide

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(
    private val context: Context,
    private val countries: List<Country>
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flagImageView: ImageView = itemView.findViewById(R.id.countryFlag)
        val nameTextView: TextView = itemView.findViewById(R.id.countryName)
        val infoTextView: TextView = itemView.findViewById(R.id.countryInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.flagImageView.setImageResource(country.flagRes)
        holder.nameTextView.text = country.name
        holder.infoTextView.text = "${country.capital} • ${country.currency} • ${country.continent}"

        holder.itemView.setOnClickListener {
            val intent = Intent(context, CountryTipsActivity::class.java).apply {
                putExtra("country", country)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = countries.size
}
