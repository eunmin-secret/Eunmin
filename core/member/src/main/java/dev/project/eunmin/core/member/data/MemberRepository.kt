package dev.project.eunmin.core.member.data

import android.net.Uri
import dev.project.eunmin.core.member.network.MemberNetworkDataSource
import dev.project.eunmin.model.Profile

interface MemberRepository {
    suspend fun getProfile(): Profile

    suspend fun createMember(email: String, password: String)

    suspend fun updateProfile(profileUri: Uri, nickname: String): Profile
    suspend fun updatePassword(password: String)

    suspend fun deleteMember()
}

class MemberRepositoryImpl(
    private val dataSource: MemberNetworkDataSource
): MemberRepository {
    override suspend fun getProfile(): Profile = dataSource.getProfile()

    override suspend fun createMember(email: String, password: String) =
        dataSource.createMember(email, password)

    override suspend fun updateProfile(profileUri: Uri, nickname: String): Profile =
        dataSource.updateProfile(profileUri, nickname)

    override suspend fun updatePassword(password: String) = dataSource.updatePassword(password)

    override suspend fun deleteMember() = dataSource.deleteMember()

}