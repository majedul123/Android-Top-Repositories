package com.majedul.assignment.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import com.majedul.assignment.data.api.NetworkService
import com.majedul.assignment.data.model.Items
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(private val networkService: NetworkService) {
     val TAG = "DataRepository"
    fun getSearchItems(type: String,sort:String): Flow<List<Items>> {
        return flow {
            Log.d(TAG, networkService.getListItems(type,sort).toString())
            emit(networkService.getListItems(type,sort))
        }.map {
            Log.d(TAG,  it.toString())

            it.items
        }
    }

}