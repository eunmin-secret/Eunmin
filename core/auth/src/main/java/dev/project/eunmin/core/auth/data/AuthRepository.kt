package dev.project.eunmin.core.auth.data

import dev.project.eunmin.core.auth.network.AuthNetworkDataSource
import javax.inject.Inject
import javax.inject.Singleton

interface AuthRepository {
    suspend fun login(email: String, password: String)
    suspend fun logout()

    suspend fun isLogin(): Boolean
}

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val dataSource: AuthNetworkDataSource
): AuthRepository {
    override suspend fun login(email: String, password: String) = dataSource.login(email, password)

    override suspend fun logout() = dataSource.logout()

    override suspend fun isLogin(): Boolean = dataSource.isLogin()
}