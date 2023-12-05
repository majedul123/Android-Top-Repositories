package com.majedul.assignment

import android.app.Application
import com.majedul.assignment.di.component.ApplicationComponent
import com.majedul.assignment.di.component.DaggerApplicationComponent
import com.majedul.assignment.di.module.ApplicationModule

class MVVMApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

}