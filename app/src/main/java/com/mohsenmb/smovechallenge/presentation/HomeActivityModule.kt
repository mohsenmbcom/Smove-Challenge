package com.mohsenmb.smovechallenge.presentation

import com.mohsenmb.smovechallenge.data.SchedulersProvider
import com.mohsenmb.smovechallenge.domain.CarsBookingRepositoryContract
import com.mohsenmb.smovechallenge.presentation.booking.BookingViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {
    @Provides
    fun provideBookingVMFactory(bookingRepository: CarsBookingRepositoryContract.BookingAvailabilityRepository,
                                schedulersProvider: SchedulersProvider): BookingViewModelFactory = BookingViewModelFactory(bookingRepository, schedulersProvider)
}