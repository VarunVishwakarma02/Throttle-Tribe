package com.example.ridingwithstranger

// Trip.kt
data class Trip(
    val riderName: String,
    val completedTrips: Int,
    val tripDays: String,
    val source: String,
    val destination: String,
    val price: String
)