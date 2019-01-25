package com.cs.ceren.vehicleapplication.data.repository

import com.cs.ceren.vehicleapplication.BuildConfig
import com.cs.ceren.vehicleapplication.data.ResultState
import com.cs.ceren.vehicleapplication.data.remote.VehicleService
import com.cs.ceren.vehicleapplication.data.remote.model.Vehicle
import com.cs.ceren.vehicleapplication.domain.repository.VehicleRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class VehicleRepositoryImpl constructor(private val vehicleService: VehicleService) : VehicleRepository {
    override suspend fun getVehicleList(): ResultState<List<Vehicle>> = withContext(IO) {
        if(BuildConfig.DEBUG) delay(500)

        try {
            val response = vehicleService.getVehicleList().await()
            ResultState.Success(response.vehicles)
        } catch (e: Exception) {
            ResultState.Error(e)
        }
    }

}