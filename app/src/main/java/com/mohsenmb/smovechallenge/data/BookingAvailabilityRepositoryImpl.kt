package com.mohsenmb.smovechallenge.data

import com.mohsenmb.smovechallenge.domain.BookingAvailability
import com.mohsenmb.smovechallenge.domain.CarsBookingRepositoryContract
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class BookingAvailabilityRepositoryImpl @Inject constructor(private val webService: SmoveWebService,
                                                            private val schedulersProvider: SchedulersProvider)
    : CarsBookingRepositoryContract.BookingAvailabilityRepository {

    override val availabilitySubject: BehaviorSubject<List<BookingAvailability>> = BehaviorSubject.create()

    override fun loadCarsAvailability(startTime: Long, endTime: Long) {
        webService
                .loadCarsBookingAvailability(startTime, endTime)
                .subscribeOn(schedulersProvider.ioScheduler())
                .subscribe({
                    availabilitySubject.onNext(it.data)
                }, {
                    availabilitySubject.onError(it)
                })
    }

}