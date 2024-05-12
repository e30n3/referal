package ru.ispu.referal.presentation.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import kotlinx.coroutines.delay
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag
import ru.alexgladkov.odyssey.core.animations.AnimationType
import ru.ispu.referal.presentation.design.icon.ReferalIcons
import ru.ispu.referal.presentation.design.icon.referalIcons.Logo
import ru.ispu.referal.presentation.navigation.NavDestinations

@Composable
fun SplashScreen() {
    ViewModel(factory = { SplashViewModel() }) { viewModel ->
        val rootController = LocalRootController.current
        val viewState = viewModel.viewStates().observeAsState()
        viewModel.viewActions().watch {
            when (it) {
                is SplashAction.NavigateToLoginScreen -> {
                    rootController.launch(
                        NavDestinations.Auth.Login.name,
                        launchFlag = LaunchFlag.SingleNewTask,
                        animationType = AnimationType.Fade(500)
                    )
                    //viewModel.completeAction()
                }

                null -> {}
            }
        }
        ScreenContent(viewState.value) { viewModel.obtainEvent(it) }
    }
}

@Composable
private fun ScreenContent(state: SplashState, eventHandler: (SplashEvent) -> Unit) {

    var isVisible by remember { mutableStateOf(false) }
    val scale = remember { Animatable(1f) }

    //todo: make logic on screen route

    Column(Modifier.fillMaxSize()) {
        Spacer(Modifier.weight(0.2f))
        Row(Modifier.weight(0.6f)) {
            Spacer(Modifier.weight(0.2f))
            Box(Modifier.fillMaxSize().weight(0.6f).graphicsLayer {
                this.scaleX = scale.value
                this.scaleY = scale.value
            }) {
                androidx.compose.animation.AnimatedVisibility(
                    isVisible,
                    Modifier.fillMaxSize(),
                    enter = fadeIn(tween(700)),
                    exit = fadeOut(tween(700))
                ) {
                    Icon(
                        imageVector = ReferalIcons.Logo,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Spacer(Modifier.weight(0.2f))
        }
        Spacer(Modifier.weight(0.2f))
    }



    LaunchedEffect(Unit) {
        isVisible = true
        delay(800)
        scale.animateTo(80f, tween(300))
        eventHandler(SplashEvent.SplashEnd)
    }
}