package ru.ispu.referal.presentation.screen.company.companyProfile

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent
import ru.ispu.referal.domain.reporitory.Repository

class CompanyProfileViewModel :
    BaseSharedViewModel<CompanyProfileState, CompanyProfileAction, CompanyProfileEvent>(
        CompanyProfileState()
    ) {

    private val repository: Repository by KoinJavaComponent.inject(Repository::class.java)
    private val currentAccount = repository.getCurrentAccount()

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        viewState = viewState.copy(
            name = currentAccount?.name.orEmpty(),
            email = currentAccount?.email.orEmpty(),
            password = currentAccount?.password.orEmpty()
        )
    }

    override fun obtainEvent(viewEvent: CompanyProfileEvent) {
        when (viewEvent) {
            CompanyProfileEvent.BackClicked -> viewAction = CompanyProfileAction.NavigateBack
            is CompanyProfileEvent.EmailChanged -> viewState =
                viewState.copy(email = viewEvent.newValue)

            is CompanyProfileEvent.NameChanged -> viewState =
                viewState.copy(name = viewEvent.newValue)

            is CompanyProfileEvent.PasswordChanged -> viewState =
                viewState.copy(password = viewEvent.newValue)

            CompanyProfileEvent.LogoutClicked -> viewAction = CompanyProfileAction.NavigateToSplash
            CompanyProfileEvent.SaveClicked -> viewModelScope.launch {
                repository.updateProfile(
                    name = viewState.name,
                    email = viewState.email,
                    password = viewState.password,
                )
                viewAction = CompanyProfileAction.NavigateBack
            }
        }
    }

}