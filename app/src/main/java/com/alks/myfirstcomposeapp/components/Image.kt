package com.alks.myfirstcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alks.myfirstcomposeapp.R

@Preview
@Composable
//.height(200.dp).width(30.dp),
//.clip(RoundedCornerShape(30.dp)),
//.clip(RoundedCornerShape(topEnd = 30.dp, bottomStart = 70.dp)),
//.border(width = 5.dp, color = Color.Red, shape = CircleShape),
fun MyImage(){
    Image(painter = painterResource(id = R.drawable.cover),
        contentDescription = "Avatar Image Profile",
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(50))
            .border(width = 5.dp, shape = CircleShape,
                brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Blue, Color.Yellow))),
        contentScale = ContentScale.FillBounds

    )
}