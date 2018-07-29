package com.mohsenmb.smovechallenge.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookingAvailability(@Expose @SerializedName("dropoff_locations") val dropOffLocations: List<DropOffLocation>,
                               @Expose @SerializedName("available_cars") val availableCars: Int,
                               @Expose @SerializedName("id") val id: Int,
                               @Expose @SerializedName("location") private val location: List<Double>) {
    val latitude = location[0]
    val longitude = location[1]
}