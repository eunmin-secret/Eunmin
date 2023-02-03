package dev.project.eunmin.core.member.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.project.eunmin.core.member.data.MemberRepository
import dev.project.eunmin.core.member.data.MemberRepositoryImpl
import dev.project.eunmin.core.member.network.MemberNetworkDataSource
import dev.project.eunmin.core.member.network.firebase.MemberNetworkDataSourceWithFirebase

@Module
@InstallIn(SingletonComponent::class)
object CoreMemberModules {
    @Provides
    fun provideMemberNetworkDataSource(
        auth: FirebaseAuth
    ): MemberNetworkDataSource = MemberNetworkDataSourceWithFirebase(auth)

    @Provides
    fun provideMemberRepository(
        dataSource: MemberNetworkDataSource
    ): MemberRepository = MemberRepositoryImpl(dataSource)
}