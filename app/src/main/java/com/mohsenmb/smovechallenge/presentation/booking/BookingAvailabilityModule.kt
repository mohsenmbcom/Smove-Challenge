package com.mohsenmb.smovechallenge.presentation.booking

import com.mohsenmb.smovechallenge.data.BookingAvailabilityRepositoryImpl
import com.mohsenmb.smovechallenge.domain.CarsBookingRepositoryContract
import dagger.Module
import dagger.Provides

@Module
class BookingAvailabilityModule {
    @Provides
    fun provideBookingAvailabilityRepository(bookingRepository: BookingAvailabilityRepositoryImpl)
            : CarsBookingRepositoryContract.BookingAvailabilityRepository = bookingRepository
}