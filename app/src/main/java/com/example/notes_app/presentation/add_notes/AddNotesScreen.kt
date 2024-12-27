package com.example.notes_app.presentation.add_notes

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.appsv.notesappwithnodejs.R
import com.example.notes_app.common.components.AppOutlinedTextField
import com.example.notes_app.common.components.AppToolBar
import com.example.notes_app.domain.models.Notes
import com.example.notes_app.presentation.add_notes.components.CustomFilterChip
import com.example.notes_app.presentation.navhost.HomeScreen


//@Preview(showSystemUi = true)
//@Composable
//private fun Prevv(){
//    AddNotesScreen(navController)
//}
@Composable
fun AddNotesScreen(
    navController: NavHostController,
    state : StateAddNoteScreen,
    event : (EventAddNoteScreen) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    )    {
        Column {
            AppToolBar(
                title = "Add Note",
                navigationIcon = Icons.AutoMirrored.Default.ArrowBack,
                onNavigationClick = {
                    navController.navigate(HomeScreen){
                        popUpTo(HomeScreen){
                            inclusive = true
                        }
                    }
                }
            )
            Column(
                modifier = Modifier.padding(8.dp)
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                AppOutlinedTextField(
                    value = state.notesTitle,
                    onValueChange = { title->
                        event(EventAddNoteScreen.NoteTitle(title))
                    },
                    maxLines = 2,
                    label = "Title"
                )

                Spacer(modifier = Modifier.height(30.dp))

                AppOutlinedTextField(
                    value = state.notesDescription,
                    onValueChange = { description->
                        event(EventAddNoteScreen.NoteDescription(description))
                    },
                    maxLines = 10,
                    height = 300.dp,
                    label = "Description"
                )

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp,Alignment.End),
                ){
                    CustomFilterChip(
                        label = "Low",
                        color = Color.Green,
                        selected = state.notesPriority == "Low",
                        onClick = {
                            event(EventAddNoteScreen.NotePriority("Low"))
                        }
                    )
                    CustomFilterChip(
                        label = "Medium",
                        color = Color.Yellow,
                        selected = state.notesPriority == "Medium",
                        onClick = {
                            event(EventAddNoteScreen.NotePriority("Medium"))
                        }
                    )
                    CustomFilterChip(
                        label = "High",
                        color = Color.Red,
                        selected = state.notesPriority == "High",
                        onClick = {
                            event(EventAddNoteScreen.NotePriority("High"))
                        }
                    )
                }
            }
        }
        FloatingActionButton(
            onClick = {
//                Log.d("NotesDetail","${state.notesTitle}, ${state.notesDescription} , ${state.notesPriority}")
                    val notes = Notes(
                        noteTitle = state.notesTitle,
                        noteDescription = state.notesDescription,
                        notePriority = state.notesPriority
                    )
                event(EventAddNoteScreen.SaveNote(notes))
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp),
            containerColor = colorResource(id = R.color.medium_green)
        ) {
            Icon(
                Icons.Filled.Done,
                contentDescription = "Add",
                tint = colorResource(id = R.color.white)
            )
        }
        LaunchedEffect(state) {
            when{
                state.savingNotes->{
                    Log.d("NotesState","Loading...")
                }
                state.notesSaved == "Notes Saved!"->{
                    Log.d("NotesState","Notes Saved!")
                    navController.navigate(HomeScreen){
                        popUpTo(HomeScreen){
                            inclusive = true
                        }
                    }
                }
                state.notesError =="Unable to save notes"->{
                    Log.d("NotesState","Error")
                }
            }
        }
    }
}