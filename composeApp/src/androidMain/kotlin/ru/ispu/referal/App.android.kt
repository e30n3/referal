package ru.ispu.referal

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import org.koin.core.context.GlobalContext.startKoin
import ru.ispu.referal.di.appModule

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        startKoin {
            modules(appModule)
        }
    }
}

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setupThemedNavigation()
    }
}

internal actual fun openUrl(url: String?) {
    val uri = url?.let { Uri.parse(it) } ?: return
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = uri
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    AndroidApp.INSTANCE.startActivity(intent)
}