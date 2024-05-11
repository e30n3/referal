package ru.ispu.referal.presentation.navigation

import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.ispu.referal.presentation.screen.login.LoginScreen
import ru.ispu.referal.presentation.screen.splash.SplashScreen


fun RootComposeBuilder.navigationGraph() {
    screen(NavDestinations.Splash.Splash.name) {
        SplashScreen()
    }
    authScreens()
    mainScreens()
}

fun RootComposeBuilder.authScreens() {
    screen(NavDestinations.Auth.Login.name) {
        LoginScreen()
    }
}

fun RootComposeBuilder.mainScreens() {
    /*    screen(NavDestionations.Main.Home.name) {
            HomeScreen()
        }*/
}

