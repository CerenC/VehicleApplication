package com.cs.ceren.vehicleapplication.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cs.ceren.vehicleapplication.R
import com.cs.ceren.vehicleapplication.data.ResultState
import com.cs.ceren.vehicleapplication.data.remote.model.Vehicle
import com.cs.ceren.vehicleapplication.di.viewmodel.ViewModelFactory
import com.cs.ceren.vehicleapplication.ui.adapter.VehicleAdapter
import com.cs.ceren.vehicleapplication.viewmodel.VehicleListViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_vehicle_list.*
import javax.inject.Inject

class VehicleListFragment : DaggerFragment() {

    companion object {
        fun newInstance() = VehicleListFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var vehicleViewModel: VehicleListViewModel

    private lateinit var vehicleAdapter: VehicleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_vehicle_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getVehicle()
    }

    private fun initView() {
        vehicleAdapter = VehicleAdapter(requireActivity())
        vehicleList.adapter = vehicleAdapter
        swipeRefreshContainer.setOnRefreshListener { getVehicle() }

    }

    private fun getVehicle() {
        swipeRefreshContainer.isRefreshing = true
        vehicleViewModel = ViewModelProviders.of(this, viewModelFactory).get(VehicleListViewModel::class.java)
        vehicleViewModel.getVehicles()
        vehicleViewModel.vehicles.observe(this, Observer {
            when (it) {
                is ResultState.Success -> handleSuccess(it.data)
                is ResultState.Error -> handleError()
            }
        })
    }

    private fun handleSuccess(vehicles: List<Vehicle>) {
        swipeRefreshContainer.isRefreshing = false
        val adapter = vehicleList.adapter as VehicleAdapter
        adapter.setList(vehicles)
        adapter.notifyDataSetChanged()
    }

    private fun handleError() {
        swipeRefreshContainer.isRefreshing = true
        val toast = Toast.makeText(context, R.string.error_message, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()

    }

}