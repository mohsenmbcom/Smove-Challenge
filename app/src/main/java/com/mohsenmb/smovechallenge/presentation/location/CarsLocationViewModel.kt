package com.mohsenmb.smovechallenge.presentation.location

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.mohsenmb.smovechallenge.data.SchedulersProvider
import com.mohsenmb.smovechallenge.domain.CarLocation
import com.mohsenmb.smovechallenge.domain.CarsBookingRepositoryContract
import com.mohsenmb.smovechallenge.presentation.Error
import com.mohsenmb.smovechallenge.presentation.ViewDataModel

class CarsLocationViewModel
constructor(private val repository: CarsBookingRepositoryContract.CarsLocationRepository,
            private val schedulersProvider: SchedulersProvider) : ViewModel() {
    val locationLiveData: LiveData<ViewDataModel<List<CarLocation>>> by lazy {
        MutableLiveData<ViewDataModel<List<CarLocation>>>()
    }

    fun loadCarsLocation() {
        (locationLiveData as MutableLiveData).value = ViewDataModel.loading(true)
        repository.loadCarsLocation()
        repository.carsLocationSubject
                .observeOn(schedulersProvider.uiScheduler())
                .subscribe({
                    (locationLiveData as MutableLiveData).value = ViewDataModel.loading(false)
                    (locationLiveData as MutableLiveData).value = ViewDataModel.success(it)
                }, {
                    (locationLiveData as MutableLiveData).value = ViewDataModel.loading(false)
                    (locationLiveData as MutableLiveData).value = ViewDataModel.failed(Error.unexpected())
                })
    }
}