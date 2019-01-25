package com.cs.ceren.vehicleapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cs.ceren.vehicleapplication.R
import com.cs.ceren.vehicleapplication.data.remote.model.Vehicle
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_vehicle_detail.*

class VehicleDetailFragment : DaggerFragment() {
    companion object {
        val TAG = VehicleDetailFragment::class.java.simpleName
        val VEHICLE = "Vehicle"

        fun newInstance(vehicle: Vehicle): VehicleDetailFragment {
            val fragmentInstance = VehicleDetailFragment()
            val bundle = Bundle()
            bundle.putParcelable(VEHICLE, vehicle)
            fragmentInstance.arguments = bundle
            return fragmentInstance
        }

    }

    private lateinit var vehicle: Vehicle;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            (it.getParcelable(VEHICLE) as? Vehicle)?.let {
                vehicle = it
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_vehicle_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        vehicleIdTextView.text = getString(R.string.vehicle_id, vehicle.vehicleId.toString())
        colorTextView.text = getString(R.string.vehicle_color, vehicle.color)
        typeTextView.text = getString(R.string.vehicle_type, vehicle.type)
        countryTextView.text = getString(R.string.vehicle_country, vehicle.country)
    }
}