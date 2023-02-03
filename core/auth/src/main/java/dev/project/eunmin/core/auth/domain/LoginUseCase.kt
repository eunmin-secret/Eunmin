package dev.project.eunmin.core.auth.domain

import dev.project.eunmin.core.auth.data.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(email: String, password: String): Flow<Unit> = flow {
        emit(repository.login(email, password))
    }
}