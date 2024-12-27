package com.example.notes_app.domain.repository

import com.example.notes_app.common.util.Resource
import com.example.notes_app.domain.models.Notes
import kotlinx.coroutines.flow.Flow

interface NotesRepository {

   suspend fun saveNotes(notes : Notes) : Flow<Resource<String>>
   suspend fun getNotes() : Flow<Resource<List<Notes>>>
}