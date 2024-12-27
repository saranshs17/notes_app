package com.example.notes_app.presentation.home

import com.example.notes_app.domain.models.Notes

data class StateHomeScreen(
    val gettingNotes : Boolean = false,
    val fetchedNotes : List<Notes>? = emptyList(),
    val error : String = ""
)