package com.mohsenmb.smovechallenge.domain

data class Location(private val location: List<Double>) {
    val latitude = location[0]
    val longitude = location[1]
}