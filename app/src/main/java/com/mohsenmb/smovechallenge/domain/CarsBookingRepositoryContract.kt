package com.mohsenmb.smovechallenge.domain

import io.reactivex.subjects.BehaviorSubject

interface CarsBookingRepositoryContract {
    interface CarsLocationRepository {
        val carsLocationSubject: BehaviorSubject<List<CarLocation>>
        fun loadCarsLocation()
    }

    interface BookingAvailabilityRepository {
        val availabilitySubject: BehaviorSubject<List<BookingAvailability>>
        fun loadCarsAvailability(startTime: Long, endTime: Long)
    }
}