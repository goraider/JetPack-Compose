package com.alks.myfirstcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alks.myfirstcomposeapp.R

@Preview
@Composable
fun MyImage(){
    Image(painter = painterResource(id = R.drawable.cover),
        contentDescription = "Avatar Image Profile",
        modifier = Modifier.height(200.dp).width(30.dp),
        contentScale = ContentScale.Inside

    )
}