package com.majedul.assignment.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import com.majedul.assignment.data.api.NetworkService
import com.majedul.assignment.data.model.Items
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(private val networkService: NetworkService) {

    fun getSearchItems(type: String,sort:String): Flow<List<Items>> {
        return flow {
            emit(networkService.getListItems(type,sort))
        }.map {
            it.items
        }
    }

}