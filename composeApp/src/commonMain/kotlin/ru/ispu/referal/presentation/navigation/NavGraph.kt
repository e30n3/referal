package ru.ispu.referal.presentation.navigation

import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.ispu.referal.domain.model.Offer
import ru.ispu.referal.domain.model.Referral
import ru.ispu.referal.presentation.navigation.bottomNavigation.BottomConfiguration
import ru.ispu.referal.presentation.navigation.bottomNavigation.CompanyHomeTab
import ru.ispu.referal.presentation.navigation.bottomNavigation.CompanyReferralTab
import ru.ispu.referal.presentation.screen.company.companyHome.CompanyHomeScreen
import ru.ispu.referal.presentation.screen.company.companyOffer.CompanyOfferScreen
import ru.ispu.referal.presentation.screen.company.companyProfile.CompanyProfileScreen
import ru.ispu.referal.presentation.screen.company.companyReferral.CompanyReferralScreen
import ru.ispu.referal.presentation.screen.company.companyReferralDetail.CompanyReferralDetailScreen
import ru.ispu.referal.presentation.screen.login.LoginScreen
import ru.ispu.referal.presentation.screen.splash.SplashScreen


fun RootComposeBuilder.navigationGraph() {
    screen(NavDestinations.Splash.Splash.name) {
        SplashScreen()
    }
    authScreens()
    companyScreens()
}

fun RootComposeBuilder.authScreens() {
    screen(NavDestinations.Auth.Login.name) {
        LoginScreen()
    }
}

fun RootComposeBuilder.companyScreens() {
    mainCompanyScreens()
    companyInnerScreens()
}


fun RootComposeBuilder.mainCompanyScreens() {
    bottomNavigation(
        name = NavDestinations.CompanyMain.Main.name,
        tabsNavModel = BottomConfiguration()
    ) {
        tab(CompanyHomeTab()) {
            screen(name = NavDestinations.CompanyMain.Home.name) {
                CompanyHomeScreen()
            }
        }
        tab(CompanyReferralTab()) {
            screen(name = NavDestinations.CompanyMain.Referrals.name) {
                CompanyReferralScreen()
            }
        }
    }
}

fun RootComposeBuilder.companyInnerScreens() {
    screen(NavDestinations.CompanyInner.Profile.name) {
        CompanyProfileScreen()
    }
    screen(NavDestinations.CompanyInner.Offer.name) {
        val offer = it as? Offer
        CompanyOfferScreen(offer)
    }
    screen(NavDestinations.CompanyInner.ReferralDetail.name) {
        val referral = it as? Referral
        CompanyReferralDetailScreen(referral)
    }
}