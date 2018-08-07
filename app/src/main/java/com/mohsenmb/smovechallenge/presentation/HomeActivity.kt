package com.mohsenmb.smovechallenge.presentation

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.mohsenmb.smovechallenge.domain.BookingAvailability
import com.mohsenmb.smovechallenge.presentation.booking.BookingAvailabilityViewModel
import com.mohsenmb.smovechallenge.presentation.booking.BookingViewModelFactory
import com.mohsenmb.smovechallenge.presentation.booking.buildBookingTopView
import com.mohsenmb.smovechallenge.presentation.utils.WINDOW_BACKGROUND_COLOR
import com.mohsenmb.smovechallenge.presentation.utils.toDip
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var bookingViewModelFactory: BookingViewModelFactory
    private val bookingVM: BookingAvailabilityViewModel by lazy {
        ViewModelProviders.of(this, bookingViewModelFactory)[BookingAvailabilityViewModel::class.java]
    }

    lateinit var carsLocationContainer: ViewGroup
    lateinit var bookingAvailabilityContainer: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        window.decorView.setBackgroundColor(WINDOW_BACKGROUND_COLOR)
        setContentView(createView())
        observeBookingAvailabilityData()
    }

    private fun createView(): View {
        val rootView = CoordinatorLayout(this)
        rootView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)

        carsLocationContainer = FrameLayout(this)
        carsLocationContainer.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        rootView.addView(carsLocationContainer)

        val bookingAvailabilityCard = CardView(this)
        val bookingAvailabilityLayoutParams = CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        bookingAvailabilityLayoutParams.marginStart = 8.toDip(this)
        bookingAvailabilityLayoutParams.marginEnd = 8.toDip(this)
        val bottomSheetBehavior = BottomSheetBehavior<FrameLayout>(this, null)
        bottomSheetBehavior.isHideable = false
        bookingAvailabilityLayoutParams.behavior = bottomSheetBehavior
        bookingAvailabilityCard.layoutParams = bookingAvailabilityLayoutParams
        bookingAvailabilityContainer = LinearLayout(this)
        bookingAvailabilityContainer.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        val bookingTopView = buildBookingTopView(this) { start, end ->
            // TODO request for bookings info
        }
        bookingTopView.post {
            bottomSheetBehavior.peekHeight = bookingTopView.height
        }
        bookingAvailabilityContainer.addView(bookingTopView)
        bookingAvailabilityCard.addView(bookingAvailabilityContainer)
        rootView.addView(bookingAvailabilityCard)

        return rootView
    }

    private fun observeBookingAvailabilityData() {
        bookingVM.availabilityLiveData.observe(this, Observer {
            when(it) {
                is Progress ->{
                    toggleProgress(it.loading)
                }
                is Failure -> {}
                is Success -> {

                }
            }
        })
    }

    private fun toggleProgress(loading: Boolean) {

    }
}