package com.example.notes_app.common.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.appsv.notesappwithnodejs.R

@Composable
fun AppOutlinedTextField(
    modifier: Modifier = Modifier,
    value:String,
    onValueChange: (String) -> Unit,
    maxLines : Int = 1,
    height : Dp = 60.dp,
    label : String
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        value = value,
        label = {Text(text = label,color = colorResource(R.color.light_green1))},
        onValueChange = {onValueChange(it)},
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.medium_green),
            unfocusedBorderColor = colorResource(id = R.color.medium_green),
            focusedTextColor = colorResource(id = R.color.white),
            unfocusedTextColor  = colorResource(id = R.color.white),
            focusedContainerColor = colorResource(id = R.color.medium_green),
            unfocusedContainerColor = colorResource(id = R.color.medium_green),
        ),

        maxLines = maxLines,
        shape = RoundedCornerShape(5.dp)
    )
}