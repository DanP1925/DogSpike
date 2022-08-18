package com.example.dogspike.di

import com.example.dogspike.data.DogsDataSource
import com.example.dogspike.data.remote.DogsRemoteDataSource
import com.example.dogspike.data.remote.DogsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideDogsService(retrofit: Retrofit): DogsService {
        return retrofit.create(DogsService::class.java)
    }

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @Singleton
    @Provides
    fun provideDogsDataSource(
        dogsService: DogsService,
        ioDispatcher: CoroutineDispatcher
    ): DogsDataSource {
        return DogsRemoteDataSource(dogsService, ioDispatcher)
    }

}