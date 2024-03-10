package com.zorbeytorunoglu.cookieclicker.feature.game

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val GAME_ROUTE = "game_route"

fun NavController.navigateToGame(navOptions: NavOptions) = navigate(GAME_ROUTE, navOptions)

fun NavGraphBuilder.gameScreen() {
    composable(GAME_ROUTE) {
        //TODO: Complete
    }
}