package com.example.notes_app.data.remote

import com.example.notes_app.domain.models.Notes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NotesAPI {

    @POST("/save-notes")
    suspend fun saveNotes(@Body notes : Notes) : Response<Notes>

    @GET("/notes")
    suspend fun getNotes() : Response<List<Notes>>
}