package com.cs.ceren.vehicleapplication.data.remote.model

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
data class VehicleResponse (
    val count: Int,
    val vehicles: List<Vehicle>,
    val currentPage: Int,
    val nextPage: Int,
    val totalPages: Int
)

@JsonClass(generateAdapter = true)
@Parcelize
data class Vehicle(
    val vehicleId : Int = 0,
    val vrn :String?,
    val country : String?,
    val color : String?,
    val type: String?,
    val default: Boolean= true
) : Parcelable

//map to db

