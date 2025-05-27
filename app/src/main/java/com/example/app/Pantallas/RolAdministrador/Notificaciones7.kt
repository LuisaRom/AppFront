package com.example.app.Pantallas.RolAdministrador

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.DoradoElegante
import com.example.app.ui.theme.GrisClaro

@Composable
fun PantallaNotificaciones(navController: NavController) {
    var selectedTab by remember { mutableStateOf("Mensajes") }
    var searchQuery by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AzulOscuro
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.White,
                    modifier = Modifier
                        .clickable { navController.popBackStack() }
                        .padding(end = 8.dp)
                )
                Text(
                    text = "Notificaciones",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(
                    onClick = { selectedTab = "Mensajes" },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedTab == "Mensajes") DoradoElegante else GrisClaro
                    )
                ) {
                    Text("Mensajes", color = AzulOscuro)
                }

                Button(
                    onClick = { selectedTab = "Pagos" },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedTab == "Pagos") DoradoElegante else GrisClaro
                    )
                ) {
                    Text("Pagos", color = AzulOscuro)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (selectedTab == "Mensajes") {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    label = { Text("Buscar", color = GrisClaro) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = DoradoElegante,
                        unfocusedBorderColor = GrisClaro,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        cursorColor = DoradoElegante
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Sin mensajes. Usa el buscador para iniciar una conversación.",
                    color = GrisClaro,
                    style = MaterialTheme.typography.bodyLarge
                )
            } else {
                PantallaPagos(navController)
            }
        }
    }
}

