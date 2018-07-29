package com.mohsenmb.smovechallenge.domain

interface CarsBookingRepositoryContract {
    interface CarsLocationRepository {
        fun loadCarsLocation()
    }

    interface BookingAvailibilityRepository {
        fun loadCarsAvailibility(startTime: Long, endTime: Long)
    }
}