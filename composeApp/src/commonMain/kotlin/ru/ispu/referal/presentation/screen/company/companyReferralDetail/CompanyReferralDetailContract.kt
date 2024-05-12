package ru.ispu.referal.presentation.screen.company.companyReferralDetail

import ru.ispu.referal.domain.model.Referral

data class CompanyReferralDetailState(
    val referral: Referral? = null,
)

sealed class CompanyReferralDetailEvent {
    data object BackClicked : CompanyReferralDetailEvent()
}

sealed class CompanyReferralDetailAction {
    data object NavigateBack : CompanyReferralDetailAction()
}

