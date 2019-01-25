package com.cs.ceren.vehicleapplication.domain.repository

import com.cs.ceren.vehicleapplication.data.ResultState
import com.cs.ceren.vehicleapplication.data.remote.model.Vehicle

interface VehicleRepository {
    suspend fun getVehicleList(): ResultState<List<Vehicle>>
}