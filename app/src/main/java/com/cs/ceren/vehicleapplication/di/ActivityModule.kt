package com.cs.ceren.vehicleapplication.di

import com.cs.ceren.vehicleapplication.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun providesMainActivity(): MainActivity

}