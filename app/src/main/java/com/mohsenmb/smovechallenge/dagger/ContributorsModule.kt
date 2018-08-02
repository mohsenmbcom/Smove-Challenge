package com.mohsenmb.smovechallenge.dagger

import com.mohsenmb.smovechallenge.presentation.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This module is supposed to provide
 * activities and fragments
 */

@Module
abstract class ContributorsModule {

    @ContributesAndroidInjector
    abstract fun bindHomeActivity(): HomeActivity
}