package com.junewon.soptkathon.data.service

import com.junewon.soptkathon.data.model.request.SignInRequest
import com.junewon.soptkathon.data.model.response.SignInResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/user/signin")
    suspend fun postSignIn(
        @Body body: SignInRequest
    ): SignInResponse
}
