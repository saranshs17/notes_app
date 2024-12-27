package com.example.notes_app.presentation.home.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.notesappwithnodejs.R
import com.example.notes_app.domain.models.Notes
import com.example.notes_app.presentation.add_notes.components.CustomFilterChip

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesCard(
    modifier: Modifier = Modifier,
    notes: Notes
){
    val chipColor = remember(notes.notePriority) {
        when (notes.notePriority){
            "Medium" -> Color.Yellow
            "High" -> Color.Red
            else -> Color.Green
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.dark_green))
    ){
        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.medium_green1)),
            modifier = Modifier
                .fillMaxWidth()
        ){
            Column(
                modifier = Modifier.padding(8.dp)
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    CustomFilterChip(
                        label = notes.notePriority,
                        color = chipColor,
                        alphaValue = 0.4f
                        , selected = false
                    ) {}
                }

                Text(
                    text = notes.noteTitle,
                    color = colorResource(id = R.color.light_green1),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = notes.noteDescription,
                    color = colorResource(id = R.color.light_green1),
                    fontSize = 15.sp,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = formatTimeStampToDDMMYYYY(notes.date!!),
                    color = colorResource(id = R.color.light_green1),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}