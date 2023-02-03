package dev.project.eunmin.core.member.network.firebase

import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import dev.project.eunmin.core.member.network.MemberNetworkDataSource
import dev.project.eunmin.model.Profile
import kotlinx.coroutines.tasks.await

class MemberNetworkDataSourceWithFirebase(
    private val auth: FirebaseAuth
): MemberNetworkDataSource {
    override suspend fun getProfile(): Profile {
        val user = auth.currentUser!!
        return Profile(user.email?: "", user.photoUrl, user.displayName)
    }

    override suspend fun createMember(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).await()
    }

    override suspend fun updateProfile(profileUri: Uri, nickname: String): Profile {
        auth.currentUser?.updateProfile(
            UserProfileChangeRequest.Builder()
                .setPhotoUri(profileUri)
                .setDisplayName(nickname)
                .build()
        )?.await()
        return getProfile()
    }

    override suspend fun updatePassword(password: String) {
        auth.currentUser?.updatePassword(password)?.await()
    }

    override suspend fun deleteMember() {
        auth.currentUser?.delete()?.await()
    }
}