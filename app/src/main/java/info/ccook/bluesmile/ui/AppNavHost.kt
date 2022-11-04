package info.ccook.bluesmile.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoute.NavHost.Devices.route
    ) {

        composable(AppRoute.NavHost.Devices.route) {
            val viewModel = hiltViewModel<DevicesScreenViewModel>()
            DevicesScreen(viewModel)
        }
    }
}
