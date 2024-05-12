package ru.ispu.referal.presentation.screen.company.companyProfile

import com.adeo.kviewmodel.BaseSharedViewModel

class CompanyProfileViewModel :
    BaseSharedViewModel<CompanyProfileState, CompanyProfileAction, CompanyProfileEvent>(
        CompanyProfileState()
    ) {
    override fun obtainEvent(viewEvent: CompanyProfileEvent) {
        when (viewEvent) {
            CompanyProfileEvent.BackClicked -> viewAction = CompanyProfileAction.NavigateBack
            CompanyProfileEvent.CompanyProfileButtonClicked -> {}
        }
    }

}