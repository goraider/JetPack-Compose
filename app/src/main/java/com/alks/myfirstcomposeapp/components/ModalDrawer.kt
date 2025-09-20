package com.alks.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.Label
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alks.myfirstcomposeapp.components.model.DrawerItem
import kotlinx.coroutines.CoroutineScope

@Composable
fun MyModalDrawer(drawerState: DrawerState, content:@Composable () -> Unit) {
    val scope: CoroutineScope = rememberCoroutineScope()
    val myItems: List<DrawerItem> = listOf(
        DrawerItem( title = "Home", icon = Icons.Default.Home, notification = 3),
        DrawerItem( title = "Fav", icon = Icons.Default.Favorite, notification = 0),
        DrawerItem( title = "Build", icon = Icons.Default.Call, notification = 9),
        DrawerItem( title = "Location", icon = Icons.Default.LocationOn, notification = 3)
    )
    var selectedIndex by remember { mutableStateOf(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(topEndPercent = 16, bottomEndPercent = 16, bottomStartPercent = 0),
                drawerContentColor = Color.White,
                drawerContainerColor = Color.Black,
                drawerTonalElevation = 10.dp
            ) {
                Spacer(Modifier.height(44.dp))
                myItems.forEachIndexed { index, drawerItem ->
                    NavigationDrawerItem(
                        label = { Text(drawerItem.title)},
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = { Icon(imageVector = drawerItem.icon, contentDescription = null) },
                        badge = {
                            if(drawerItem.notification > 0){
                                Badge (
                                    containerColor = if(selectedIndex == index) Color.Black else Color.Gray,
                                    contentColor = if(selectedIndex == index) Color.White else Color.White,
                                ){ Text(drawerItem.notification.toString()) }
                            }
                        },
                        shape = RoundedCornerShape(0),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color.Gray,
                            selectedIconColor = Color.Black,
                            selectedTextColor = Color.Black,
                            selectedBadgeColor = Color.Yellow,
                            unselectedContainerColor = Color.White,
                            unselectedTextColor = Color.Gray,
                            unselectedBadgeColor = Color.Green,
                            unselectedIconColor = Color.Gray
                        )
                    )
                }
                //Text("ejemplo 1", modifier = Modifier.clickable{ scope.launch { drawerState.close() } })
            }
        },
        scrimColor = Color.Transparent.copy(alpha = 0.7f)
    ) {
        content()
    }
    
}