package com.mohsenmb.smovechallenge.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DropOffLocation(@Expose @SerializedName("id") val id: Int,
                           @Expose @SerializedName("location") private val location: List<Double>) {
    val latitude = location[0]
    val longitude = location[1]
}