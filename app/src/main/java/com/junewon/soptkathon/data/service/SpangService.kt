package com.junewon.soptkathon.data.service

import com.junewon.soptkathon.data.model.request.SignInRequest
import com.junewon.soptkathon.data.model.response.ProgressDataResponse
import com.junewon.soptkathon.data.model.response.SignInResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SpangService {
    @POST("api/user/signin")
    suspend fun postSignIn(
        @Body body: SignInRequest
    ): SignInResponse

    @GET("/user")
    suspend fun getProgressBar(@Path("startId") startId: String): ProgressDataResponse
}
