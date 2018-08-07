package com.mohsenmb.smovechallenge.presentation.booking

import com.mohsenmb.smovechallenge.domain.BookingAvailability

data class BookingListItem(val bookingAvailability: BookingAvailability,
                           val title: String)