package com.mohsenmb.smovechallenge.presentation.location

import android.content.Context
import android.view.View
import com.mohsenmb.smovechallenge.domain.CarLocation

class CarsLocationViewBuilder(private val context: Context) {

    init {
        buildView()
    }

    lateinit var view: View

    var carsLocation: List<CarLocation>? = null
        set(value) {
            field = value
            refreshView()
        }

    private fun buildView() {

    }

    private fun refreshView() {

    }
}