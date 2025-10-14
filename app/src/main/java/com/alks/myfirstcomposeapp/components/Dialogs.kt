@file:OptIn(ExperimentalMaterial3Api::class)

package com.alks.myfirstcomposeapp.components

import android.R
import android.app.Dialog
import android.provider.CalendarContract
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.alks.myfirstcomposeapp.components.model.PokemonCombat
import java.util.Calendar

@Composable
fun MyDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }

    if(showDialog){
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = { Button(onClick = { showDialog = false })  { Text("Entendido!") } },
            dismissButton = { TextButton(onClick = { showDialog = false }) {Text("Cancelar")} },
            text = { Text("Esta es mi Descripción") },
            title = { Text("¿Quieres hacer esta acción?") },
            icon = { Icon(
                imageVector = Icons.Default.Info,
                contentDescription = null)
            },
            shape = RoundedCornerShape(10),
            containerColor = Color.Black,
            iconContentColor = Color.White,
            titleContentColor = Color.White,
            textContentColor = Color.Gray,
            tonalElevation = 12.dp,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.SecureOn,
                usePlatformDefaultWidth = true,
                decorFitsSystemWindows = true
            )
        )
    }
}


@Composable
fun MyDateDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }
    val calendar: Calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, 1)
    calendar.set(Calendar.MONTH, Calendar.JANUARY)

    val datePickerState: DatePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        initialDisplayedMonthMillis = calendar.timeInMillis,
        yearRange = 2024 ..2025,
        initialDisplayMode = DisplayMode.Picker,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val filterCalendar: Calendar = Calendar.getInstance().apply { timeInMillis = utcTimeMillis }
                val day: Int = filterCalendar.get(Calendar.DAY_OF_MONTH)
                return day % 2 == 0
            }
        }

    )

    if(showDialog){
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    val result: Long? = datePickerState.selectedDateMillis
                    if(result != null ){
                        val newCalendar: Calendar = Calendar.getInstance().apply { timeInMillis = result }
                        val day: Int = newCalendar.get(Calendar.DAY_OF_MONTH)
                        val month: Int = newCalendar.get(Calendar.MONTH) + 1
                        Log.i("Fecha seleccionada", "DIA: $day, MES: $month")
                    }
                }) { Text("Confirmar") }
            },
            colors = DatePickerDefaults.colors()
        ) {
            DatePicker(datePickerState)
        }
    }
}

@Composable
fun MyTimePicker(modifier: Modifier = Modifier) {
    var showTimePicker: Boolean by remember { mutableStateOf(true) }
    val timePickerState: TimePickerState = rememberTimePickerState(
        initialHour = 7,
        initialMinute = 33,
        is24Hour = false
    )

    if(showTimePicker) {
        Dialog(onDismissRequest = {showTimePicker = false }) {
            Column(modifier = Modifier
                .background(Color.White)
                .padding(24.dp)){
                TimePicker(timePickerState,
                    layoutType = TimePickerLayoutType.Vertical,
                    colors = TimePickerDefaults.colors(

                        clockDialColor = Color.Black,
                        clockDialSelectedContentColor = Color.Black,
                        clockDialUnselectedContentColor = Color.Gray,
                        selectorColor = Color.White,
                        containerColor = Color.White,
                        periodSelectorBorderColor = Color.Black,

                        periodSelectorSelectedContentColor = Color.White,
                        periodSelectorSelectedContainerColor = Color.Black,
                        periodSelectorUnselectedContainerColor = Color.White,
                        periodSelectorUnselectedContentColor = Color.Gray,

                        timeSelectorSelectedContentColor = Color.White,
                        timeSelectorSelectedContainerColor = Color.Black,
                        timeSelectorUnselectedContainerColor = Color.White,
                        timeSelectorUnselectedContentColor = Color.Gray,


                    )
                    )
            }
        }
    }
}

@Composable
fun MyCustomDialog(
    modifier: Modifier = Modifier,
    pokemonCombat: PokemonCombat,
    showDialog: Boolean,
    onStartCombat: ()-> Unit,
    onDismissDialog: ()-> Unit
    ) {

    if(showDialog){
        Dialog(onDismissRequest = {onDismissDialog()}) {
            Column(modifier = modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(24))
                .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.Center
                    ) {
                    Text(pokemonCombat.pokemonA, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(Modifier.width(4.dp))
                    Text("VS")
                    Spacer(Modifier.width(4.dp))
                    Text(pokemonCombat.pokemonB, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
                Button(onClick = { onStartCombat() }) {
                    Text("A LUCHAR!")
                }
                TextButton(onClick = { onDismissDialog() }) {
                    Text("Cancelar")
                }
            }

        }
    }
    
}