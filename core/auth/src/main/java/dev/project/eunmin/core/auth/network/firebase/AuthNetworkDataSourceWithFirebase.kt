package dev.project.eunmin.core.auth.network.firebase

import com.google.firebase.auth.FirebaseAuth
import dev.project.eunmin.core.auth.network.AuthNetworkDataSource
import kotlinx.coroutines.tasks.await

class AuthNetworkDataSourceWithFirebase(
    private val auth: FirebaseAuth
): AuthNetworkDataSource {
    override suspend fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).await()
    }

    override suspend fun logout() {
        auth.signOut()
    }

    override suspend fun isLogin(): Boolean =
        auth.currentUser != null
}