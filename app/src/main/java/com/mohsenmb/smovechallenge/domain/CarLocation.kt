package com.mohsenmb.smovechallenge.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CarLocation(@Expose @SerializedName("id") val id: Long,
                       @Expose @SerializedName("latitude") val latitude: Double,
                       @Expose @SerializedName("longitude") val longitude: Long,
                       @Expose @SerializedName("is_on_trip") val isOnTrip: Boolean)