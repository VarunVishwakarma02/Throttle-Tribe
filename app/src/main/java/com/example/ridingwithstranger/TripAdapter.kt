package com.example.ridingwithstranger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// TripAdapter.kt
class TripAdapter(private val trips: List<Trip>) :
    RecyclerView.Adapter<TripAdapter.TripViewHolder>() {

    class TripViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val riderName: TextView = itemView.findViewById(R.id.tv_rider_name)
        val completedTrips: TextView = itemView.findViewById(R.id.tv_completed_trips)
        val tripDays: TextView = itemView.findViewById(R.id.tv_trip_days)
        val source: TextView = itemView.findViewById(R.id.tv_source_location)
        val destination: TextView = itemView.findViewById(R.id.tv_destination_location)
        val price: TextView = itemView.findViewById(R.id.tv_trip_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_of_trip, parent, false)
        return TripViewHolder(view)
    }

    override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
        val trip = trips[position]
        holder.riderName.text = trip.riderName
        holder.completedTrips.text = "${trip.completedTrips} trips completed"
        holder.tripDays.text = trip.tripDays
        holder.source.text = trip.source
        holder.destination.text = trip.destination
        holder.price.text = trip.price
    }

    override fun getItemCount() = trips.size
}