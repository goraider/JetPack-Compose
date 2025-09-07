package com.alks.myfirstcomposeapp.components.state

data class CheckBoxState(
    val id: String,
    val label: String,
    val checked: Boolean = false,
)