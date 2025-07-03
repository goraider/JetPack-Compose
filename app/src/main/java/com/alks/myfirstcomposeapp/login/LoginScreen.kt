package com.alks.myfirstcomposeapp.login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name! XOXOXOXPEPITO",
        modifier = modifier
    )
}

@Preview(
    widthDp = 50,
    heightDp = 150,
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4
)
@Composable
fun example(){
    Text("Aris :)")
}