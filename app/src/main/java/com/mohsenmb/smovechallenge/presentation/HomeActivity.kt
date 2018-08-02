package com.mohsenmb.smovechallenge.presentation

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.mohsenmb.smovechallenge.presentation.utils.WINDOW_BACKGROUND_COLOR
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    lateinit var carsLocationContainer: ViewGroup
    lateinit var bookingAvailabilityContainer: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        window.decorView.setBackgroundColor(WINDOW_BACKGROUND_COLOR)
        setContentView(createView())
    }

    private fun createView(): View {
        val rootView = CoordinatorLayout(this)
        rootView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)

        carsLocationContainer = FrameLayout(this)
        carsLocationContainer.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        rootView.addView(carsLocationContainer)

        bookingAvailabilityContainer = LinearLayout(this)
        bookingAvailabilityContainer.setBackgroundColor(Color.GREEN)
        val bookingAvailabilityLayoutParams = CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        val bottomSheetBehavior = BottomSheetBehavior<FrameLayout>(this, null)
        bottomSheetBehavior.isHideable = false
        bottomSheetBehavior.peekHeight = 600
        bookingAvailabilityLayoutParams.behavior = bottomSheetBehavior
        bookingAvailabilityContainer.layoutParams = bookingAvailabilityLayoutParams
        rootView.addView(bookingAvailabilityContainer)

        return rootView
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector
}