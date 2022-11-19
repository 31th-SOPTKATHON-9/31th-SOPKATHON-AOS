package com.junewon.soptkathon.data.service

import com.junewon.soptkathon.data.model.response.ProgressDataResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SpangService {
    @GET("/user")
    suspend fun getProgressBar(): ProgressDataResponse
}
