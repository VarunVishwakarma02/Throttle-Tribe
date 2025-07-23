package com.example.ridingwithstranger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Explore : Fragment(R.layout.fragment_explore) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_explore)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val trips = listOf(
            Trip("Aman Sharma", 25, "3 days", "Connaught Place, New Delhi", "Kargil", "₹10000"),
            Trip("Varun Vishwakarma", 15, "3 days", "Greater Noida", "Leh", "₹8000"),
            Trip("Rohit Kumar", 10, "2 days", "Gurgaon", "Shimla", "₹5000"),
            Trip("Priya Singh", 20, "4 days", "Noida", "Manali", "₹12000"),
            Trip("Anjali Verma", 30, "5 days", "Faridabad", "Dharamshala", "₹15000"),
            Trip("Rahul Gupta", 18, "3 days", "Ghaziabad", "Rishikesh", "₹6000"),
            // Add more Trip objects as needed
        )
        recyclerView.adapter = TripAdapter(trips)
    }
}