package com.cs.ceren.vehicleapplication.di

import com.cs.ceren.vehicleapplication.ui.fragment.VehicleDetailFragment
import com.cs.ceren.vehicleapplication.ui.fragment.VehicleListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun provideListFragment(): VehicleListFragment

    @ContributesAndroidInjector
    abstract fun provideDetailFragment(): VehicleDetailFragment

}