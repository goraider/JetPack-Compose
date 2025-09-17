package com.alks.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.alks.myfirstcomposeapp.R
import com.alks.myfirstcomposeapp.components.state.CheckBoxState

@Composable
fun MySwitch(modifier: Modifier = Modifier) {

    var switchState by remember { mutableStateOf(true) }

    Box (
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Switch(checked = switchState,
            onCheckedChange = { switchState = it },
            thumbContent = {
                Icon(
                    painter = painterResource(R.drawable.ic_personita),
                    contentDescription = ""
                )
            }, enabled = true,
            colors = SwitchDefaults.colors(
                //Bolita
                checkedThumbColor = Color.Red,
                uncheckedThumbColor = Color.Blue,
                disabledCheckedThumbColor = Color.Yellow,
                disabledUncheckedThumbColor = Color.Cyan,
                //Icono
                checkedIconColor = Color.Green,
                uncheckedIconColor = Color.Cyan,
                disabledCheckedIconColor = Color.Red,
                disabledUncheckedIconColor = Color.Red,
                //Bordes
                checkedBorderColor = Color.Magenta,
                uncheckedBorderColor = Color.Magenta,
                disabledCheckedBorderColor = Color.Magenta,
                disabledUncheckedBorderColor = Color.Magenta,
                //Track
                checkedTrackColor = Color.White,
                uncheckedTrackColor = Color.Black,
                disabledCheckedTrackColor = Color.White,
                disabledUncheckedTrackColor = Color.LightGray
            )
        )
    }
}

@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf(false) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable{ state = !state}) {
            Checkbox(
                checked = state,
                onCheckedChange = {state = it},
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    checkmarkColor = Color.DarkGray,
                    uncheckedColor = Color.Blue,
                    disabledCheckedColor = Color.Yellow,
                    disabledUncheckedColor = Color.Green
                )
            )
            Spacer(Modifier.width(12.dp))
            Text("Acepto los terminos y condiciones")
        }
    }
}

@Composable
fun ParentCheckBoxes(modifier: Modifier = Modifier) {
    var state by remember {
        mutableStateOf(
        listOf(
                CheckBoxState("terms", "Aceptar Terminos y Condiciones"),
                CheckBoxState("newsletter", "Recibir la Newsletter", true),
                CheckBoxState("updates", "Recibir Actualizaciones")
            )
        )
    }
    Column(modifier = modifier.fillMaxSize()){
        state.forEach { myState ->
            CheckBoxWithText(checkBoxState = myState) {
                state = state.map {
                    if(it.id == myState.id){
                       myState.copy(checked = !myState.checked, label = "CHECKEADO")
                    }else{
                        it
                    }
                }
            }
        }

    }
}

@Composable
fun CheckBoxWithText(
        modifier: Modifier = Modifier,
        checkBoxState: CheckBoxState,
        onCheckBoxChange: (CheckBoxState) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable{ onCheckBoxChange(checkBoxState) }
    ) {
        Checkbox(
            checked = checkBoxState.checked,
            onCheckedChange = { onCheckBoxChange(checkBoxState) },
            enabled = true
        )
        Spacer(Modifier.width(12.dp))
        Text(checkBoxState.label)
    }
}

@Composable
fun MyTriStateCheckBox(modifier: Modifier = Modifier) {
    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(false) }

    LaunchedEffect(child1, child2) {
        parentState = when{
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column(modifier = modifier){
        Row(verticalAlignment = Alignment.CenterVertically){
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                child1 = newState
                child2 = child1
            })
            Text("Seleccionar Todo")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ){
            Checkbox(child1, onCheckedChange = { child1 = it})
            Text("Ejemplo 1")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ){
            Checkbox(child2, onCheckedChange = { child2 = it})
            Text("Ejemplo 2")
        }
    }
}

@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {
    var state: Boolean by remember { mutableStateOf(false) }

    Row(modifier = modifier.clickable{ state = !state }, verticalAlignment = Alignment.CenterVertically){
        RadioButton(
            selected = state,
            onClick = { state = true },
            enabled = false,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green,
                disabledUnselectedColor = Color.Magenta
            )
        )
        Text("Ejemplo 1")
    }
}

@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {
    var selectedName: String by remember { mutableStateOf("") }
    Column(modifier = modifier){
        RadioButtonComponent(name = "Coors", selectedName = selectedName){ selectedName = it }
        RadioButtonComponent(name = "Aris", selectedName = selectedName){ selectedName = it }
        RadioButtonComponent(name = "FillDor", selectedName = selectedName){ selectedName = it }
        RadioButtonComponent(name = "Troousk", selectedName = selectedName){ selectedName = it }
    }

}

@Composable
fun RadioButtonComponent(
    name: String,
    selectedName: String,
    onItemSelected:(String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically){
        RadioButton(selected = name === selectedName, onClick = { onItemSelected(name) })
        Text(name, Modifier.clickable{ onItemSelected(name)})
    }

}