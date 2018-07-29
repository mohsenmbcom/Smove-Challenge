package com.mohsenmb.smovechallenge.data

import io.reactivex.Scheduler

interface SchedulersProvider {
    fun uiScheduler(): Scheduler
    fun ioScheduler(): Scheduler
}