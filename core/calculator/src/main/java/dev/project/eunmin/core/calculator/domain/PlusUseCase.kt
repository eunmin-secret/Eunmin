package dev.project.eunmin.core.calculator.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import javax.inject.Inject

class PlusUseCase @Inject constructor() {
    suspend operator fun invoke(first: BigDecimal, second: BigDecimal): BigDecimal =
        withContext(Dispatchers.Default) { first.plus(second) }
}