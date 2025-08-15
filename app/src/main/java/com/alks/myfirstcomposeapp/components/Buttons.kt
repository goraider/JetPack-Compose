package com.alks.myfirstcomposeapp.components
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyButtons(modifier: Modifier){
    Column(modifier = modifier){
        Button(onClick = { Log.i("Test de Button!!", "Botón Pulsando") }) {
            Text("tOuCh Me, PUSH")
        }
    }
}