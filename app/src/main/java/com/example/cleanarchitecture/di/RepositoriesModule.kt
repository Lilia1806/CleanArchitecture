package com.example.cleanarchitecture.di

import com.example.data.repositories.UserDataRepositoryImpl
import com.example.domain.repositories.UserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun provideUserRepository(repositoryImpl: UserDataRepositoryImpl): UserDataRepository
}