package ru.ispu.referal.presentation.screen.splash

data class SplashState(
    val titleText: String = "",
    val counter: Int = 0
)

sealed class SplashEvent {
    data object SplashEnd : SplashEvent()
}

sealed class SplashAction {
    data object NavigateToLoginScreen : SplashAction()
}

