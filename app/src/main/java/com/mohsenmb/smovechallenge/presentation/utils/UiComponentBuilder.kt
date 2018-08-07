package com.mohsenmb.smovechallenge.presentation.utils

import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView

fun buildTitleTextView(context: Context,
                       text: CharSequence? = null,
                       gravity: Int = Gravity.START or Gravity.CENTER_VERTICAL,
                       margins: Int = 8.toDip(context)): TextView =
        buildTextView(context, text, 16F, gravity, margins)

fun buildSubTitleTextView(context: Context,
                          text: CharSequence? = null,
                          gravity: Int = Gravity.START or Gravity.CENTER_VERTICAL,
                          margins: Int = 8.toDip(context)): TextView =
        buildTextView(context, text, 14F, gravity, margins)

fun buildTextView(context: Context, text: CharSequence?, textSize: Float, gravity: Int, margins: Int): TextView {
    val textView = TextView(context)
    textView.gravity = gravity
    textView.text = text
    textView.textSize = textSize
    val layoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
    layoutParams.setMargins(margins, margins, margins, margins)
    textView.layoutParams = layoutParams
    return textView
}