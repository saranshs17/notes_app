package com.example.notes_app.data.repository

import com.example.notes_app.common.util.Resource
import com.example.notes_app.data.remote.NotesAPI
import com.example.notes_app.domain.models.Notes
import com.example.notes_app.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NotesRepositoryImpl(
    private val notesAPI: NotesAPI
) : NotesRepository {
    override suspend fun saveNotes(notes: Notes): Flow<Resource<String>> = flow {

        emit(Resource.Loading())

        val status = notesAPI.saveNotes(notes).code()

        try{
            if(status == 201){
                emit(Resource.Success("Notes Saved!"))
            }else{
                emit(Resource.Error("Unable to save notes"))
            }
        }
        catch (e:Exception){
            emit(Resource.Error(e.message!!))
        }
    }

    override suspend fun getNotes(): Flow<Resource<List<Notes>>>  = flow{
        val status = notesAPI.getNotes().code()
        try{
            val notesList = notesAPI.getNotes().body()
            if(status == 200){
                emit(Resource.Success(notesList))
            }else{
                emit(Resource.Error("Unable to save notes"))
            }
        }
        catch (e:Exception){
            emit(Resource.Error(e.message!!))
        }
    }
}