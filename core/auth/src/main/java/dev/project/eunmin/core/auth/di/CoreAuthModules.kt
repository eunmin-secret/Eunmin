package dev.project.eunmin.core.auth.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.project.eunmin.core.auth.data.AuthRepository
import dev.project.eunmin.core.auth.data.AuthRepositoryImpl
import dev.project.eunmin.core.auth.network.AuthNetworkDataSource
import dev.project.eunmin.core.auth.network.firebase.AuthNetworkDataSourceWithFirebase

@Module
@InstallIn(SingletonComponent::class)
object CoreAuthModules {
    @Provides
    fun provideAuthNetworkDataSource(
        auth: FirebaseAuth
    ): AuthNetworkDataSource = AuthNetworkDataSourceWithFirebase(auth)

    @Provides
    fun provideAuthRepository(
        dataSource: AuthNetworkDataSource
    ): AuthRepository = AuthRepositoryImpl(dataSource)
}