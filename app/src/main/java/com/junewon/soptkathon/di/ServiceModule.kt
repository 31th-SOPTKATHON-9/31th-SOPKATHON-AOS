package com.junewon.soptkathon.di

import com.junewon.soptkathon.data.service.SpangService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    private inline fun <reified T> Retrofit.create(): T = this.create(T::class.java)

    @Provides
    @Singleton
    fun providesAuthService(retrofit: Retrofit): SpangService =
        retrofit.create()
}
