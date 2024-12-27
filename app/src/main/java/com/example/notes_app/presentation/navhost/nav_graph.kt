package com.example.notes_app.presentation.navhost

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notes_app.presentation.add_notes.AddNotesScreen
import com.example.notes_app.presentation.add_notes.ViewModelAddNoteScreen
import com.example.notes_app.presentation.home.HomeScreen
import com.example.notes_app.presentation.home.ViewModelHome
import org.koin.androidx.compose.koinViewModel

@Composable
fun SetupNavHost(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeScreen
    ){
        composable<HomeScreen>
        {
            val viewModel : ViewModelHome = koinViewModel()
            val state by viewModel.getNotesState.collectAsState()
            HomeScreen(
                navController = navController,
                state = state
            )
        }

        composable<AddNoteScreen>
        {
            val viewModel : ViewModelAddNoteScreen = koinViewModel()
            val state by viewModel.notesState.collectAsState()
            AddNotesScreen(
                navController,
                state = state,
                event = viewModel::onEvent
            )
        }
    }
}