package com.cs.ceren.vehicleapplication.ui.util

import android.support.v7.util.DiffUtil
import com.cs.ceren.vehicleapplication.data.remote.model.Vehicle

class VehicleDiffUtil(
    private val newList: List<Vehicle>? = null,
    private val oldList: List<Vehicle>? = null
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList?.get(oldItemPosition)?.vehicleId == newList?.get(newItemPosition)?.vehicleId
    }

    override fun getOldListSize(): Int {
        return oldList?.size ?: 0
    }

    override fun getNewListSize(): Int {
        return newList?.size ?: 0
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList?.get(oldItemPosition) === newList?.get(newItemPosition)
    }
}
