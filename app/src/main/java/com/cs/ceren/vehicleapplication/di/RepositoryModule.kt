package com.cs.ceren.vehicleapplication.di

import com.cs.ceren.vehicleapplication.data.remote.VehicleService
import com.cs.ceren.vehicleapplication.data.repository.VehicleRepositoryImpl
import com.cs.ceren.vehicleapplication.domain.repository.VehicleRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun bindVehicleRepo(vehicleService: VehicleService): VehicleRepository = VehicleRepositoryImpl(vehicleService)
}