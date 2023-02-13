package dev.project.eunmin.feature.calculator.compose.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import dev.project.eunmin.feature.calculator.compose.ui.CalculatorRoute

const val CALCULATOR_ROUTE = "calculator_route"

fun NavController.navigateToCalculator(navOptions: NavOptions? = null) {
    this.navigate(CALCULATOR_ROUTE, navOptions)
}

fun NavGraphBuilder.calculatorScreen() {
    composable(route = CALCULATOR_ROUTE) {
        CalculatorRoute()
    }
}
