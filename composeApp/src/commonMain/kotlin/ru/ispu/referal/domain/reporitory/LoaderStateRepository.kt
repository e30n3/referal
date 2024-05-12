package ru.ispu.referal.domain.reporitory

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoaderStateRepository {

    private val _state = MutableStateFlow(false)

    val state: StateFlow<Boolean> = _state

    fun start() {
        _state.value = true
    }

    fun stop() {
        _state.value = false
    }

}