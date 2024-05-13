package ru.ispu.referal.presentation.navigation

object NavDestinations {

    enum class Splash {
        Splash
    }

    enum class Auth {
        Login
    }

    enum class CompanyMain {
        CompanyMain, CompanyHome, CompanyReferrals,
    }

    enum class CompanyInner {
        CompanyOffer, CompanyReferralDetail
    }

    enum class AgentMain {
        AgentMain, AgentHome, AgentReferrals,
    }

    enum class AgentInner {
        AgentOffer, AgentNewReferral, AgentReferralDetail
    }

    enum class Common {
        Profile
    }

}