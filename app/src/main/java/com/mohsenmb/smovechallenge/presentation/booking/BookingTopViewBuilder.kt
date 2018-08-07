package com.mohsenmb.smovechallenge.presentation.booking

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.support.v7.widget.AppCompatButton
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.mohsenmb.smovechallenge.R
import com.mohsenmb.smovechallenge.presentation.utils.toDip
import java.text.SimpleDateFormat
import java.util.*


fun buildBookingTopView(context: Context, onTimeRangeSelectedListener: (Date, Date) -> Unit): View {
    val root = LinearLayout(context)
    root.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
    root.orientation = LinearLayout.VERTICAL

    val textStartDate = TextView(context)
    textStartDate.text = "Booking date and time"
    textStartDate.textSize = 16F
    val textStartDateLayoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
    textStartDate.gravity = Gravity.CENTER
    textStartDateLayoutParams.topMargin = 16.toDip(context)
    textStartDateLayoutParams.marginStart = 16.toDip(context)
    textStartDateLayoutParams.marginEnd = 16.toDip(context)
    textStartDateLayoutParams.bottomMargin = 8.toDip(context)
    textStartDate.layoutParams = textStartDateLayoutParams
    root.addView(textStartDate)

    val buttonSelectDateTimeRange = AppCompatButton(context)
    buttonSelectDateTimeRange.text = "[SET YOUR DESIRED DATE TIME RANGE]"
    buttonSelectDateTimeRange.setTextColor(0xFF558866.toInt())
    val outValue = TypedValue()
    context.theme.resolveAttribute(R.attr.selectableItemBackground, outValue, true)
    buttonSelectDateTimeRange.setBackgroundResource(outValue.resourceId)
    val buttonDateTimeLayoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
    buttonDateTimeLayoutParams.marginStart = 16.toDip(context)
    buttonDateTimeLayoutParams.marginEnd = 16.toDip(context)
    buttonDateTimeLayoutParams.bottomMargin = 16.toDip(context)
    buttonSelectDateTimeRange.layoutParams = buttonDateTimeLayoutParams
    buttonSelectDateTimeRange.setOnClickListener {
        val now = Calendar.getInstance()
        DatePickerDialog(it.context, { _, startYear, startMonth, startDay ->
            TimePickerDialog(it.context, { _, startHour, startMinute ->
                DatePickerDialog(it.context, { _, endYear, endMonth, endDay ->
                    TimePickerDialog(it.context, { _, endHour, endMinute ->
                        val format = SimpleDateFormat("MM/dd/yyyy HH:mm")
                        val calStartTime = Calendar.getInstance()
                        calStartTime[Calendar.YEAR] = startYear
                        calStartTime[Calendar.MONTH] = startMonth
                        calStartTime[Calendar.DAY_OF_MONTH] = startDay
                        calStartTime[Calendar.HOUR_OF_DAY] = startHour
                        calStartTime[Calendar.MINUTE] = startMinute

                        val calEndTime = Calendar.getInstance()
                        calEndTime[Calendar.YEAR] = endYear
                        calEndTime[Calendar.MONTH] = endMonth
                        calEndTime[Calendar.DAY_OF_MONTH] = endDay
                        calEndTime[Calendar.HOUR_OF_DAY] = endHour
                        calEndTime[Calendar.MINUTE] = endMinute

                        buttonSelectDateTimeRange.text = String.format("%s - %s",
                                format.format(calStartTime.time), format.format(calEndTime.time))
                        onTimeRangeSelectedListener(calStartTime.time, calEndTime.time)
                    }, 0, 0, true).show()
                }, now[Calendar.YEAR],
                        now[Calendar.MONTH], now[Calendar.DAY_OF_MONTH]).show()
            }, 0, 0, true).show()
        }, now[Calendar.YEAR],
                now[Calendar.MONTH], now[Calendar.DAY_OF_MONTH]).show()
    }
    root.addView(buttonSelectDateTimeRange)

    return root
}