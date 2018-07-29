package com.mohsenmb.smovechallenge.domain

interface CarsBookingRepositoryContract {
    interface CarsLocationRepository {
        fun loadCarsLocation()
    }

    interface BookingAvailabilityRepository {
        fun loadCarsAvailability(startTime: Long, endTime: Long)
    }
}