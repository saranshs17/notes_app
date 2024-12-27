package com.example.notes_app.presentation.main_activity

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.appsv.notesappwithnodejs.R
import com.example.notes_app.presentation.navhost.SetupNavHost
import com.example.notes_app.presentation.ui.theme.Notes_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                Color(0xFF344E41).toArgb(),
            )
        )
        installSplashScreen()
        setContent {
            Notes_appTheme {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.dark_green))
                ){
                    SetupNavHost()
                }
            }
        }
    }
}
