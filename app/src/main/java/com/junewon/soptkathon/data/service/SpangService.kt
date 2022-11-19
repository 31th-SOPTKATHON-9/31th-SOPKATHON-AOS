package com.junewon.soptkathon.data.service

import com.junewon.soptkathon.data.model.request.UserRequest
import com.junewon.soptkathon.data.model.response.BaseResponse
import com.junewon.soptkathon.data.model.response.ResponseSearchDTO
import com.junewon.soptkathon.data.model.response.ResponseUserDTO
import kotlinx.serialization.Serializable
import retrofit2.Call
import retrofit2.http.*

interface SpangService {

    @GET("/habit/search")
    fun getSearch(
        @Query("starName") search: String ="다카",
        @Header("userId") userId: Int = 1
    ): Call<BaseResponse<ResponseSearchDTO>>

    @GET("/home/day")
    fun getDays(
        @Query("filter")dayIdx: Int)
    : Call<BaseResponse<ResponseSearchDTO>>

    @POST("/habit")
    fun postObserver(
        @Body userRequset: UserRequest
    ): Call<BaseResponse<ResponseUserDTO>>
}
@Serializable
data class User(
    val statId: String
)
