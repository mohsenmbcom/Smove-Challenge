package com.mohsenmb.smovechallenge.presentation.booking

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.mohsenmb.smovechallenge.data.SchedulersProvider
import com.mohsenmb.smovechallenge.domain.BookingAvailability
import com.mohsenmb.smovechallenge.domain.CarsBookingRepositoryContract
import com.mohsenmb.smovechallenge.presentation.Error
import com.mohsenmb.smovechallenge.presentation.ViewDataModel

class BookingAvailabilityViewModel
constructor(private val repository: CarsBookingRepositoryContract.BookingAvailabilityRepository,
            private val schedulersProvider: SchedulersProvider)
    : ViewModel() {
    val availabilityLiveData: LiveData<ViewDataModel<List<BookingAvailability>>> by lazy {
        MutableLiveData<ViewDataModel<List<BookingAvailability>>>()
    }

    fun loadCarsAvailability(startTime: Long, endTime: Long) {
        (availabilityLiveData as MutableLiveData).value = ViewDataModel.loading(true)
        repository.loadCarsAvailability(startTime, endTime)
        repository.availabilitySubject
                .observeOn(schedulersProvider.uiScheduler())
                .subscribe({
                    (availabilityLiveData as MutableLiveData).value = ViewDataModel.loading(false)
                    (availabilityLiveData as MutableLiveData).value = ViewDataModel.success(it)
                }, {
                    (availabilityLiveData as MutableLiveData).value = ViewDataModel.loading(false)
                    (availabilityLiveData as MutableLiveData).value = ViewDataModel.failed(Error.unexpected())
                })
    }

}