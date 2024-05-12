package ru.ispu.referal.presentation.design.icon

import androidx.compose.ui.graphics.vector.ImageVector
import ru.ispu.referal.presentation.design.icon.referalIcons.Logo
import kotlin.collections.List as ____KtList

object ReferalIcons

private var allIcons: ____KtList<ImageVector>? = null

val ReferalIcons.AllIcons: ____KtList<ImageVector>
    get() {
        if (allIcons != null) {
            return allIcons!!
        }
        allIcons = listOf(Logo)
        return allIcons!!
    }
