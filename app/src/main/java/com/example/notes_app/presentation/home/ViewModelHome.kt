package com.example.notes_app.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes_app.common.util.Resource
import com.example.notes_app.domain.repository.NotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ViewModelHome : ViewModel(), KoinComponent{
    private val notesRepository : NotesRepository by inject()
    private val _getNotesState = MutableStateFlow(StateHomeScreen())
    val getNotesState = _getNotesState

    init{
        getNotes()
    }

    private fun getNotes() {
        viewModelScope.launch {
            notesRepository.getNotes().collect{resource->
                when(resource){
                    is Resource.Loading -> {
                        _getNotesState.value = getNotesState.value.copy(gettingNotes = true)
                    }
                    is Resource.Success -> {
                        _getNotesState.value = getNotesState.value.copy(fetchedNotes = resource.data, gettingNotes = false)
                    }
                    is Resource.Error -> {
                        _getNotesState.value = getNotesState.value.copy(error = resource.message , gettingNotes = false)
                    }
                }
            }
        }
    }
}