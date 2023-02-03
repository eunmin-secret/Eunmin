package dev.project.eunmin.core.member.network

import android.net.Uri
import dev.project.eunmin.model.Profile

interface MemberNetworkDataSource {
    suspend fun getProfile(): Profile

    suspend fun createMember(email: String, password: String)

    suspend fun updateProfile(profileUri: Uri, nickname: String): Profile
    suspend fun updatePassword(password: String)

    suspend fun deleteMember()
}