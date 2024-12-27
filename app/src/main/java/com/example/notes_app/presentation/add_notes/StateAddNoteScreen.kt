package com.example.notes_app.presentation.add_notes

data class StateAddNoteScreen(
    val savingNotes:Boolean = false,
    val notesSaved:String = "",
    val notesError:String = "",
    val notesTitle : String = "",
    val notesDescription : String = "",
    val notesPriority : String = "Low"
)