package com.example.notes_app.domain.models

data class Notes(
    val noteTitle : String,
    val noteDescription : String,
    val notePriority : String,
    val date : String? = null
)
