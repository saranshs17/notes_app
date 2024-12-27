package com.example.notes_app.common.components


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import com.appsv.notesappwithnodejs.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolBar(
    modifier: Modifier = Modifier,
    title:String,
    navigationIcon: ImageVector? = null,
    onNavigationClick: () -> Unit = {}
){
    TopAppBar(
        title = {
            Text(text = title, color = Color.White)
        },
        colors = TopAppBarDefaults.topAppBarColors()
            .copy(
                containerColor = colorResource(id = R.color.dark_green)
            ),
        navigationIcon = {
            if(navigationIcon != null){
                IconButton(onClick = onNavigationClick) {
                    Icon(
                        imageVector = navigationIcon,
                        contentDescription = "Navigation Icon",
                        tint = Color.White
                    )
                }
            }
        },
        modifier = modifier
    )
}