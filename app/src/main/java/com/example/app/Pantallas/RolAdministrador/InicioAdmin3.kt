package com.example.app.Pantallas.RolAdministrador

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.DoradoElegante
import com.example.app.ui.theme.GrisClaro

@Composable
fun PantallaInicioAdmin(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AzulOscuro
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Panel de Administración",
                color = GrisClaro,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            BotonAdmin("Crear Usuario") {
                navController.navigate("PantallaCrearUsuario")
            }

            Spacer(modifier = Modifier.height(16.dp))

            BotonAdmin("Dashboard") {
                navController.navigate("PantallaDashboardAdmin")
            }

        }
    }
}

@Composable
fun BotonAdmin(texto: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = DoradoElegante),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Text(
            text = texto,
            fontSize = 18.sp,
            color = AzulOscuro
        )
    }
}

