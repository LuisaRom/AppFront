package com.example.app.Pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app.R
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.GrisClaro
import com.example.app.ui.theme.GrisOscuro

@Composable
fun PantallaDashboardCelador(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AzulOscuro)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(GrisOscuro)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menú",
                tint = Color.White,
                modifier = Modifier.clickable {
                    navController.navigate("PantallaMenuCelador")
                }
            )
            Text("NOMBRE APP", color = Color.White, fontWeight = FontWeight.Bold)
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notificaciones",
                tint = Color.White,
                modifier = Modifier.clickable {
                    navController.navigate("PantallaNotificacionesCelador")
                }
            )
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Text(
                text = "NOMBRE CONJUNTO",
                modifier = Modifier.padding(8.dp),
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("NOVEDADES", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No hay publicaciones disponibles.",
                color = GrisClaro,
                fontSize = 16.sp
            )
        }
    }
}