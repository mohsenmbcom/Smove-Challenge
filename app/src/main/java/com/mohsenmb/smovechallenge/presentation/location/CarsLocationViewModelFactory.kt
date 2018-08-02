package com.mohsenmb.smovechallenge.presentation.location

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.mohsenmb.smovechallenge.data.SchedulersProvider
import com.mohsenmb.smovechallenge.domain.CarsBookingRepositoryContract
import javax.inject.Inject

class CarsLocationViewModelFactory @Inject constructor(private val repository: CarsBookingRepositoryContract.CarsLocationRepository,
                                                       private val schedulersProvider: SchedulersProvider)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CarsLocationViewModel(repository, schedulersProvider) as T
    }

}