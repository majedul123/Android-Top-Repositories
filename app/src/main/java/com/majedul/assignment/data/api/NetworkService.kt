package com.majedul.assignment.data.api

import com.majedul.assignment.data.model.DataResponse
import com.majedul.assignment.utils.AppConstant.API_PACKAGE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {
    @Headers("package: $API_PACKAGE")
    @GET("search/repositories")
    suspend fun getListItems(@Query("q") type: String, @Query("sort") sort:String): DataResponse

}