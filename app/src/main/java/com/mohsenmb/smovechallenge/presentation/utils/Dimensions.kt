package com.mohsenmb.smovechallenge.presentation.utils

import android.content.Context
import android.util.TypedValue

fun Int.toDip(context: Context): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(), context.resources.displayMetrics).toInt()
}
fun Int.toSp(context: Context): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
            this.toFloat(), context.resources.displayMetrics)
}