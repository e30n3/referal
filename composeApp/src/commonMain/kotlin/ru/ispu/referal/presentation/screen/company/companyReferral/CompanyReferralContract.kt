package ru.ispu.referal.presentation.screen.company.companyReferral

import ru.ispu.referal.domain.model.Referral

data class CompanyReferralState(
    val text: String = "Company Referral",
    val referrals: List<Referral> = emptyList()
)

sealed class CompanyReferralEvent {
    data class ReferralClicked(val referral: Referral) : CompanyReferralEvent()


}

sealed class CompanyReferralAction {
    data class NavigateToReferralDetail(val referral: Referral) : CompanyReferralAction()
}

