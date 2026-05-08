package com.example.travelguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TravelTipAdapter(
    private val travelTips: List<TravelTip>
) : RecyclerView.Adapter<TravelTipAdapter.TravelTipViewHolder>() {

    class TravelTipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iconImageView: ImageView = itemView.findViewById(R.id.tipIcon)
        val categoryTextView: TextView = itemView.findViewById(R.id.tipCategory)
        val titleTextView: TextView = itemView.findViewById(R.id.tipTitle)
        val descriptionTextView: TextView = itemView.findViewById(R.id.tipDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelTipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_travel_tip, parent, false)
        return TravelTipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TravelTipViewHolder, position: Int) {
        val travelTip = travelTips[position]
        holder.iconImageView.setImageResource(travelTip.iconRes)
        holder.categoryTextView.text = travelTip.category
        holder.titleTextView.text = travelTip.title
        holder.descriptionTextView.text = travelTip.description
    }

    override fun getItemCount(): Int = travelTips.size
}
