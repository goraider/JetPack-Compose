package com.alks.myfirstcomposeapp.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alks.myfirstcomposeapp.components.model.NavItem

@Preview
@Composable
fun MyNavigationBar(modifier: Modifier = Modifier) {
    val itemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Fav", Icons.Default.Favorite),
        NavItem("Profile", Icons.Default.Person),
    )
    var selectedIndex: Int by remember { mutableIntStateOf(2) }
    NavigationBar(
        containerColor = Color.Black,
        tonalElevation = 1.dp
    ) {
        itemList.forEachIndexed { index, item ->
            getNavigationItems(item, isSelected = index == selectedIndex){
                selectedIndex = index
            }
        }
    }
}

@Composable
fun RowScope.getNavigationItems(navItem: NavItem, isSelected: Boolean, onItemClick: () -> Unit) {
    NavigationBarItem(
        selected = isSelected,
        onClick = { onItemClick()},
        icon = { Icon(imageVector = navItem.icon, contentDescription = "") },
        label = { Text(navItem.name) },
        alwaysShowLabel = false,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.White,
            selectedTextColor = Color.White,
            indicatorColor = Color.Black,
            unselectedIconColor = Color.DarkGray,
            unselectedTextColor = Color.White,
            disabledIconColor = Color.Gray,
            disabledTextColor = Color.Gray
        )
    )
}