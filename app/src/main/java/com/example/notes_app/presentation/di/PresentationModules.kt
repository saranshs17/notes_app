package com.example.notes_app.presentation.di

import com.example.notes_app.presentation.add_notes.ViewModelAddNoteScreen
import com.example.notes_app.presentation.home.ViewModelHome
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel{
        ViewModelAddNoteScreen()
    }
    viewModel{
        ViewModelHome()
    }
}