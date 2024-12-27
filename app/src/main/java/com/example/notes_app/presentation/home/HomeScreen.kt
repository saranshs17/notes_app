package com.example.notes_app.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.appsv.notesappwithnodejs.R
import com.example.notes_app.common.components.AppToolBar
import com.example.notes_app.presentation.home.components.NotesCard
import com.example.notes_app.presentation.navhost.AddNoteScreen


//@Preview(showSystemUi = true)
//@Composable
//private fun Prev(){
//    HomeScreen(navController = rememberNavController())
//}
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    state : StateHomeScreen
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AppToolBar(
                title = "Notes",
            )
            if(isNotesFetched(state)){
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(6.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalItemSpacing = 8.dp
                ) {
                    items(state.fetchedNotes!!){
                        NotesCard(notes = it)
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = {
                navController.navigate(AddNoteScreen)
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp),
            containerColor = colorResource(id = R.color.medium_green)
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Add",
                tint = colorResource(id = R.color.white)
            )
        }
    }
}

fun isNotesFetched(state: StateHomeScreen): Boolean {
    return when{
        state.gettingNotes -> false
        state.fetchedNotes!!.isNotEmpty() -> true
        else -> {false}
    }
}
