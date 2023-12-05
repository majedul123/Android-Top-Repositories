package com.majedul.assignment.di.component

import dagger.Component
import com.majedul.assignment.di.ActivityScope
import com.majedul.assignment.di.module.ActivityModule
import com.majedul.assignment.ui.views.SearchActivity

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: SearchActivity)

}