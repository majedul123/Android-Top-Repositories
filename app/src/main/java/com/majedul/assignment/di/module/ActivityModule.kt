package com.majedul.assignment.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import com.majedul.assignment.data.repository.DataRepository
import com.majedul.assignment.di.ActivityContext
import com.majedul.assignment.ui.base.ViewModelProviderFactory
import com.majedul.assignment.ui.views.SearchAdapter
import com.majedul.assignment.ui.views.SearchViewModel

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideSearchViewModel(dataRepository: DataRepository): SearchViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(SearchViewModel::class) {
                SearchViewModel(dataRepository)
            })[SearchViewModel::class.java]
    }
    @Provides
    fun provideSearchAdapter() = SearchAdapter(ArrayList())

}