package com.cs.ceren.vehicleapplication.data.remote

import com.cs.ceren.vehicleapplication.data.remote.model.VehicleResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface VehicleService{
    @GET("vehicles")
    fun getVehicleList() : Deferred<VehicleResponse>
}