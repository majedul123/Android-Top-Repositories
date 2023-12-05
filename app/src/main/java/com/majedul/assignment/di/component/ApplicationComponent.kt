package com.majedul.assignment.di.component

import android.content.Context
import dagger.Component
import com.majedul.assignment.MVVMApplication
import com.majedul.assignment.data.api.NetworkService
import com.majedul.assignment.data.repository.DataRepository
import com.majedul.assignment.di.ApplicationContext
import com.majedul.assignment.di.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MVVMApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getTopHeadlineRepository(): DataRepository

}