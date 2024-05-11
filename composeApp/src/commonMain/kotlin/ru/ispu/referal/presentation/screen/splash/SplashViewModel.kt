package ru.ispu.referal.presentation.screen.splash

import com.adeo.kviewmodel.BaseSharedViewModel

class SplashViewModel : BaseSharedViewModel<SplashState, SplashAction, SplashEvent>(SplashState()) {

    override fun obtainEvent(viewEvent: SplashEvent) {
        when (viewEvent) {
            SplashEvent.SplashEnd -> onSplashEnded()
        }
    }

    private fun onSplashEnded() {
        viewAction = SplashAction.NavigateToLoginScreen
    }


}