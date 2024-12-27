package com.example.notes_app.base

import android.app.Application
import com.example.notes_app.data.di.dataModules
import com.example.notes_app.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class NotesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(
                presentationModule , dataModules
            )
            androidContext(this@NotesApplication)
        }
    }
}