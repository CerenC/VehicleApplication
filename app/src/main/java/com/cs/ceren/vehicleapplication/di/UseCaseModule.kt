package com.cs.ceren.vehicleapplication.di

import com.cs.ceren.vehicleapplication.domain.repository.VehicleRepository
import com.cs.ceren.vehicleapplication.domain.usecase.GetVehicles
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun bindGetVehicle(repository: VehicleRepository): GetVehicles = GetVehicles(repository)
}