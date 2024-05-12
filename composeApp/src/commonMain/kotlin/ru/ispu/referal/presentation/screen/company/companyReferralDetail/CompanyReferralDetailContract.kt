package ru.ispu.referal.presentation.screen.company.companyReferralDetail

import ru.ispu.referal.domain.model.Referral

data class CompanyReferralDetailState(
    val referral: Referral? = null,
    val amount: String = "",
)

sealed class CompanyReferralDetailEvent {
    data object BackClicked : CompanyReferralDetailEvent()
    data object RejectClicked : CompanyReferralDetailEvent()
    data object NextClicked : CompanyReferralDetailEvent()
    data object NextClickedWithAmount : CompanyReferralDetailEvent()
    data class AmountChanged(val amount: String) : CompanyReferralDetailEvent()
}

sealed class CompanyReferralDetailAction {
    data object NavigateBack : CompanyReferralDetailAction()
}

