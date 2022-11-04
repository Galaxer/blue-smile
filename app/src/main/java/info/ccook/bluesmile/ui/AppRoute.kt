package info.ccook.bluesmile.ui

sealed class AppRoute {

    sealed class NavHost : AppRoute() {

        abstract val route: String

        object Devices : NavHost() {
            override val route: String = "devices"
        }
    }
}
