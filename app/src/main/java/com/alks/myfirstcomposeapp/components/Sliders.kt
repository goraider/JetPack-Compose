@file:OptIn(ExperimentalMaterial3Api::class)

package com.alks.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(modifier: Modifier = Modifier) {
    var myValue: Float by remember { mutableFloatStateOf(0.5f) }
    Column(modifier = modifier.padding(horizontal = 30.dp)) {
        Slider(value = myValue,
            enabled = false,
            onValueChange = { myValue = it},
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                disabledThumbColor = Color.DarkGray,
                activeTrackColor = Color.Red,
                disabledActiveTrackColor = Color.Gray,
                disabledActiveTickColor = Color.DarkGray,
                inactiveTickColor = Color.Green,
                inactiveTrackColor = Color.Blue,
                disabledInactiveTickColor = Color.DarkGray,
                disabledInactiveTrackColor = Color.Gray
            ))
        Text(myValue.toString())
    }
}

@Composable
fun MySliderAdvance(modifier: Modifier = Modifier) {
    var example: String by remember { mutableStateOf(":(") }
    val state: SliderState = remember { SliderState(
        value = 5f,
        valueRange = 0f..10f,
        steps = 9,
        //Sliders para sacar Ventanas Dialog. Confirmación, Acción, Validación
        onValueChangeFinished = { example = "Noche MEXAN" }

    ) }
    val colors:SliderColors = SliderDefaults.colors(
        thumbColor = Color.Black,
        disabledThumbColor = Color.DarkGray,
        activeTrackColor = Color.Red,
        disabledActiveTrackColor = Color.Gray,
        disabledActiveTickColor = Color.DarkGray,
        inactiveTickColor = Color.Green,
        inactiveTrackColor = Color.Blue,
        disabledInactiveTickColor = Color.DarkGray,
        disabledInactiveTrackColor = Color.Gray
    )
    //thum es el pin o circulo del de avance o retroceso del slider
    //el track es la linea del 0.1% al 1%

    //en el thumb de un slider se puede colocar una imagen
    //    thumb = {
    //        Image(
    //            painter = painterResource(id = R.drawable.ic_android),
    //            contentDescription = "Slider Image",
    //            modifier = Modifier.size(24.dp)
    //        )
    //    }

    // en el thumb tambien puedes ponder un texto con el valor del progreso del Slider
    // thumb = { state: SliderState -> Text(state.value.toString())}
    Column(modifier = modifier.padding(horizontal = 32.dp)) {
        Slider(state,
            colors = colors,
            thumb = { state: SliderState -> Box(Modifier
                .width(10.dp)
                .height(1000.dp)
                .background(Color.Red)) },
            track = { Box(Modifier
                .size(25.dp)
                .background(Color.Red)) })
        Text(example)
    }
}

@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {
    val colors:SliderColors = SliderDefaults.colors(
        thumbColor = Color.Black,
        disabledThumbColor = Color.DarkGray,
        activeTrackColor = Color.Red,
        disabledActiveTrackColor = Color.Gray,
        disabledActiveTickColor = Color.DarkGray,
        inactiveTickColor = Color.Green,
        inactiveTrackColor = Color.Blue,
        disabledInactiveTickColor = Color.DarkGray,
        disabledInactiveTrackColor = Color.Gray
    )
    val state: RangeSliderState = remember{ RangeSliderState(
            activeRangeStart = 3f,
            activeRangeEnd = 6f,
            valueRange = 0f..10f,
            steps = 8,
            onValueChangeFinished = {}
    )}
    Column(modifier = modifier.padding(horizontal = 30.dp)){
        RangeSlider(
            state = state,
            colors = colors,
            startThumb = {
                Box(Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.Black),
                    contentAlignment = Alignment.Center
                ){
                    //it.activeRangeStart.toString()
                    Text(String.format("%.1f", it.activeRangeStart), color = Color.White)
                }
            },
            endThumb = {
                Box(Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.Black),
                    contentAlignment = Alignment.Center
                ){
                    //it.activeRangeStart.toString()
                    Text(String.format("%.1f", it.activeRangeStart), color = Color.White)
                }
            }
        )
    }

}
