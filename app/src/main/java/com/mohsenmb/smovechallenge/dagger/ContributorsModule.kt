package com.mohsenmb.smovechallenge.dagger

import com.mohsenmb.smovechallenge.presentation.HomeActivity
import com.mohsenmb.smovechallenge.presentation.HomeActivityModule
import com.mohsenmb.smovechallenge.presentation.booking.BookingAvailabilityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This module is supposed to provide
 * activities and fragments
 */

@Module
abstract class ContributorsModule {

    @ContributesAndroidInjector(modules = [BookingAvailabilityModule::class, HomeActivityModule::class])
    abstract fun bindHomeActivity(): HomeActivity
}