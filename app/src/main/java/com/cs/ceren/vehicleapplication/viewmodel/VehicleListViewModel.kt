package com.cs.ceren.vehicleapplication.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.cs.ceren.vehicleapplication.data.ResultState
import com.cs.ceren.vehicleapplication.data.remote.model.Vehicle
import com.cs.ceren.vehicleapplication.domain.usecase.GetVehicles
import kotlinx.coroutines.launch
import javax.inject.Inject

class VehicleListViewModel @Inject constructor(private val getVehicles: GetVehicles) : BaseViewModel() {

    private val _vehicles = MutableLiveData<ResultState<List<Vehicle>>>()
    val vehicles: LiveData<ResultState<List<Vehicle>>>
        get() = _vehicles

    fun getVehicles() {
        launch {
            try {
                _vehicles.value = getVehicles.execute()
            } catch (e: Exception) {
                println(e.printStackTrace())
            }
        }
    }


}