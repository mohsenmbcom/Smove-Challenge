package com.mohsenmb.smovechallenge.data

import com.mohsenmb.smovechallenge.domain.BookingAvailability
import com.mohsenmb.smovechallenge.domain.CarLocation
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SmoveWebService {
    @GET("locations")
    fun loadCarsLocation(): Single<WebServiceResponse<List<CarLocation>>>

    @GET("availability")
    fun loadCarsBookingAvailability(@Query("startTime") startTime: Long,
                                    @Query("endTime") endTime: Long): Single<WebServiceResponse<List<BookingAvailability>>>
}