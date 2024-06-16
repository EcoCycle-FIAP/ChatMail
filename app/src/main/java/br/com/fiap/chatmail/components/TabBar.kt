package br.com.fiap.chatmail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import br.com.fiap.chatmail.R

enum class Screens {
    Calendar, MailBox, Favorites
}

data class NavItem(
    val icon: ImageVector, val route: String
)

val listOfNavItems = listOf(
    NavItem(
        icon = Icons.Default.DateRange, route = Screens.Calendar.name
    ), NavItem(
        icon = Icons.Default.MailOutline, route = Screens.MailBox.name
    ), NavItem(
        icon = Icons.Default.Favorite, route = Screens.Favorites.name
    )
)

@Composable
fun TabBar(navController: NavController) {

    Surface(
        modifier = Modifier
            .padding(top = 50.dp)
            .background(color = colorResource(id = R.color.background_color))
    ) {
        Column {
            UserHeader()
            Spacer(modifier = Modifier.height(15.dp))
            NavigationBar(
                containerColor = colorResource(id = R.color.chatmail_white_color),
                modifier = Modifier.height(100.dp)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                listOfNavItems.forEach { navItem ->
                    val selected =
                        currentDestination?.hierarchy?.any { it.route == navItem.route } == true

                    NavigationBarItem(selected = selected, onClick = {
                        navController.navigate(navItem.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }, icon = {
                        val boxSize = 120.dp
                        val iconSize = 35.dp
                        Box(modifier = Modifier.size(boxSize)) {
                            Icon(
                                modifier = Modifier
                                    .size(iconSize)
                                    .align(Alignment.Center),
                                imageVector = navItem.icon,
                                contentDescription = null,
                            )
                            HorizontalDivider(
                                color = if (selected) colorResource(id = R.color.primary_color) else colorResource(
                                    id = R.color.transparent
                                ),
                                thickness = 4.dp,
                                modifier = Modifier
                                    .width(boxSize)
                                    .align(Alignment.BottomCenter)
                            )
                        }
                    }, colors = NavigationBarItemDefaults.colors(
                        indicatorColor = colorResource(id = R.color.transparent)
                    )
                    )
                }
            }
        }
    }
}

