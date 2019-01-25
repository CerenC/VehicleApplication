package com.cs.ceren.vehicleapplication.ui.activity

import android.os.Bundle
import com.cs.ceren.vehicleapplication.R
import com.cs.ceren.vehicleapplication.data.remote.model.Vehicle
import com.cs.ceren.vehicleapplication.ui.adapter.VehicleAdapter
import com.cs.ceren.vehicleapplication.ui.fragment.VehicleDetailFragment
import com.cs.ceren.vehicleapplication.ui.fragment.VehicleListFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity(), VehicleAdapter.ItemTouchListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, VehicleListFragment.newInstance())
                .commit()
        }
    }

    override fun onItemClick(vehicle: Vehicle) {
        header.text = vehicle.vrn
        supportFragmentManager.beginTransaction()
            .add(R.id.container, VehicleDetailFragment.newInstance(vehicle))
            .addToBackStack(VehicleDetailFragment.TAG)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        header.text = getString(R.string.app_name)
    }

}
