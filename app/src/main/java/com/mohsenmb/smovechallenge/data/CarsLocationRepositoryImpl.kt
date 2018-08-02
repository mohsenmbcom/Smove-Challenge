package com.mohsenmb.smovechallenge.data

import com.mohsenmb.smovechallenge.domain.CarLocation
import com.mohsenmb.smovechallenge.domain.CarsBookingRepositoryContract
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class CarsLocationRepositoryImpl @Inject constructor(private val webService: SmoveWebService,
                                                     private val schedulersProvider: SchedulersProvider)
    : CarsBookingRepositoryContract.CarsLocationRepository {
    override val carsLocationSubject: BehaviorSubject<List<CarLocation>> = BehaviorSubject.create()

    override fun loadCarsLocation() {
        webService
                .loadCarsLocation()
                .subscribeOn(schedulersProvider.ioScheduler())
                .subscribe({
                    carsLocationSubject.onNext(it.data)
                }, {
                    carsLocationSubject.onError(it)
                })
    }

}