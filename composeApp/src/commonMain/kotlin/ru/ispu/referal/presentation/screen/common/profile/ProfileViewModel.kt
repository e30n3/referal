package ru.ispu.referal.presentation.screen.common.profile

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent
import ru.ispu.referal.domain.reporitory.Repository

class ProfileViewModel :
    BaseSharedViewModel<ProfileState, ProfileAction, ProfileEvent>(
        ProfileState()
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
            password = currentAccount?.password.orEmpty(),
            account = currentAccount,
            accountStat = repository.getAccountStats()
        )
    }

    override fun obtainEvent(viewEvent: ProfileEvent) {
        when (viewEvent) {
            ProfileEvent.BackClicked -> viewAction = ProfileAction.NavigateBack
            is ProfileEvent.EmailChanged -> viewState =
                viewState.copy(email = viewEvent.newValue)

            is ProfileEvent.NameChanged -> viewState =
                viewState.copy(name = viewEvent.newValue)

            is ProfileEvent.PasswordChanged -> viewState =
                viewState.copy(password = viewEvent.newValue)

            ProfileEvent.LogoutClicked -> viewAction = ProfileAction.NavigateToSplash
            ProfileEvent.SaveClicked -> viewModelScope.launch {
                repository.updateProfile(
                    name = viewState.name,
                    email = viewState.email,
                    password = viewState.password,
                )
                viewAction = ProfileAction.NavigateBack
            }
        }
    }

}