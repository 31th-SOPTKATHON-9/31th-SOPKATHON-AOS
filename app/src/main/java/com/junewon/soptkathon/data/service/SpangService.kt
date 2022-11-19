package com.junewon.soptkathon.data.service

import com.junewon.soptkathon.data.model.request.UserRequest
import com.junewon.soptkathon.data.model.response.BaseResponse
import com.junewon.soptkathon.data.model.response.ResponseSearchDTO
import com.junewon.soptkathon.data.model.response.ResponseUserDTO
import kotlinx.serialization.Serializable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SpangService {

    @GET("/habit/search")
    fun getSearch(
        @Query("starName")search: String
    ): BaseResponse<ResponseSearchDTO>

    @GET("/home/day")
    fun getDays(
        @Query("filter")dayIdx: Int)
    : BaseResponse<ResponseSearchDTO>

    @POST("/habit")
    fun postObserver(
        @Body userRequset: UserRequest
    ): BaseResponse<ResponseUserDTO>
}
@Serializable
data class User(
    val statId: String
)
