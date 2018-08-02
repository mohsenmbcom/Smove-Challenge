package com.mohsenmb.smovechallenge.presentation.booking

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.mohsenmb.smovechallenge.data.SchedulersProvider
import com.mohsenmb.smovechallenge.domain.CarsBookingRepositoryContract
import javax.inject.Inject

class BookingViewModelFactory @Inject constructor(private val repository: CarsBookingRepositoryContract.BookingAvailabilityRepository,
                                                  private val schedulersProvider: SchedulersProvider)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookingAvailabilityViewModel(repository, schedulersProvider) as T
    }
}