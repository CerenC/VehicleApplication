package com.cs.ceren.vehicleapplication.domain.usecase

import com.cs.ceren.vehicleapplication.data.ResultState
import com.cs.ceren.vehicleapplication.data.remote.model.Vehicle
import com.cs.ceren.vehicleapplication.domain.repository.VehicleRepository

class GetVehicles constructor(private val vehicleRepository: VehicleRepository) {

    suspend fun execute(): ResultState<List<Vehicle>> {
        return vehicleRepository.getVehicleList()
    }

}