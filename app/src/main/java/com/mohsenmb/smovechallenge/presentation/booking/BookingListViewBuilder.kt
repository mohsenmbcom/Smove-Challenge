package com.mohsenmb.smovechallenge.presentation.booking

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.mohsenmb.smovechallenge.domain.BookingAvailability
import com.mohsenmb.smovechallenge.presentation.utils.buildSubTitleTextView
import com.mohsenmb.smovechallenge.presentation.utils.buildTitleTextView
import com.mohsenmb.smovechallenge.presentation.utils.toDip

private const val TAG_TITLE = "title"
private const val TAG_SUBTITLE = "sub_title"

fun buildBookingList(context: Context, availabilityList: List<BookingAvailability>) {
    val recyclerItems = RecyclerView(context)
    val recyclerParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
    recyclerItems.layoutParams = recyclerParams
    recyclerItems.layoutManager = LinearLayoutManager(context)

}

class BookingListViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)

fun createItemView(context: Context): View {
    val _8Dip = 8.toDip(context)
    val _4Dip = 4.toDip(context)

    val rootView = CardView(context)
    val rootParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
    rootParams.marginStart = _8Dip
    rootParams.marginEnd = _8Dip
    rootParams.topMargin = _4Dip
    rootParams.bottomMargin = _4Dip
    rootView.layoutParams = rootParams

    val innerContainer = LinearLayout(context)
    innerContainer.setPadding(_8Dip, _8Dip, _8Dip, _8Dip)
    innerContainer.orientation = LinearLayout.VERTICAL
    val innerParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
    innerContainer.layoutParams = innerParams

    val textTitle = buildTitleTextView(context)
    textTitle.tag = TAG_TITLE
    innerContainer.addView(textTitle)

    val textSubtitle = buildSubTitleTextView(context)
    textSubtitle.tag = TAG_SUBTITLE
    innerContainer.addView(textSubtitle)

    rootView.addView(innerContainer)
    return rootView
}

class BookingListAdapter(val bookingItems: MutableList<BookingListItem>) :
        RecyclerView.Adapter<BookingListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingListViewHolder =
            BookingListViewHolder(createItemView(parent.context))

    override fun getItemCount(): Int =
            bookingItems.size


    override fun onBindViewHolder(holder: BookingListViewHolder, position: Int) {
        val textTitle = holder.itemView.findViewWithTag<TextView>(TAG_TITLE)
        val textSubTitle = holder.itemView.findViewWithTag<TextView>(TAG_SUBTITLE)
        val item = bookingItems[position]
        textTitle.text = item.title
        textSubTitle.text = "Available cars count: ${item.bookingAvailability.availableCars}"
    }
}

