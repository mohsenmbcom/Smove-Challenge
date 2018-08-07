package com.mohsenmb.smovechallenge.presentation.booking

import android.support.v7.util.DiffUtil

class BookingListItemDiffUtilCallback(private val oldItems: List<BookingListItem>,
                                      private val newItems: List<BookingListItem>) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldItems[oldItemPosition] == newItems[newItemPosition]

    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldItems[oldItemPosition] == newItems[newItemPosition]

}