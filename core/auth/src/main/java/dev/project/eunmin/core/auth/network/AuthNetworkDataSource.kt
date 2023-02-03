package dev.project.eunmin.core.auth.network

interface AuthNetworkDataSource {
    suspend fun login(email: String, password: String)
    suspend fun logout()

    suspend fun isLogin(): Boolean

}