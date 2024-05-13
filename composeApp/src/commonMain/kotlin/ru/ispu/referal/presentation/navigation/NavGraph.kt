package ru.ispu.referal.presentation.navigation

import androidx.compose.material3.Text
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.ispu.referal.domain.model.Offer
import ru.ispu.referal.domain.model.Referral
import ru.ispu.referal.presentation.navigation.bottomNavigation.BottomConfiguration
import ru.ispu.referal.presentation.navigation.bottomNavigation.HomeTab
import ru.ispu.referal.presentation.navigation.bottomNavigation.ReferralTab
import ru.ispu.referal.presentation.screen.agent.agentHome.AgentHomeScreen
import ru.ispu.referal.presentation.screen.common.profile.ProfileScreen
import ru.ispu.referal.presentation.screen.company.companyHome.CompanyHomeScreen
import ru.ispu.referal.presentation.screen.company.companyOffer.CompanyOfferScreen
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
    agentScreens()
    commonScreens()
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
        name = NavDestinations.CompanyMain.CompanyMain.name,
        tabsNavModel = BottomConfiguration()
    ) {
        tab(HomeTab()) {
            screen(name = NavDestinations.CompanyMain.CompanyHome.name) {
                CompanyHomeScreen()
            }
        }
        tab(ReferralTab()) {
            screen(name = NavDestinations.CompanyMain.CompanyReferrals.name) {
                CompanyReferralScreen()
            }
        }
    }
}

fun RootComposeBuilder.companyInnerScreens() {
    screen(NavDestinations.CompanyInner.CompanyOffer.name) {
        val offer = it as? Offer
        CompanyOfferScreen(offer)
    }
    screen(NavDestinations.CompanyInner.CompanyReferralDetail.name) {
        val referral = it as? Referral
        CompanyReferralDetailScreen(referral)
    }
}

fun RootComposeBuilder.agentScreens() {
    mainAgentScreens()
}

fun RootComposeBuilder.mainAgentScreens() {
    bottomNavigation(
        name = NavDestinations.AgentMain.AgentMain.name,
        tabsNavModel = BottomConfiguration()
    ) {
        tab(HomeTab()) {
            screen(name = NavDestinations.AgentMain.AgentHome.name) {
                AgentHomeScreen()
            }
        }
        tab(ReferralTab()) {
            screen(name = NavDestinations.AgentMain.AgentReferrals.name) {
                //CompanyReferralScreen()
                Text("2")
            }
        }
    }
}

fun RootComposeBuilder.commonScreens() {
    screen(NavDestinations.Common.Profile.name) {
        ProfileScreen()
    }
}

