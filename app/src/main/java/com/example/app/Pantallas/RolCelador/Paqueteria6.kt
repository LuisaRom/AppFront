package com.example.app.Pantallas.RolCelador

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.DoradoElegante
import com.example.app.ui.theme.GrisClaro

@Composable
fun PantallaPaqueteriaCelador(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AzulOscuro)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.width(18.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                tint = GrisClaro,
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Paqueteria",
                style = MaterialTheme.typography.headlineSmall,
                color = GrisClaro
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.LocalShipping,
                contentDescription = null,
                tint = DoradoElegante,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Paquetes a Entregar",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PaqueteItem(nombre = "Paquete 1", torre = " ", apto = " ") {
                navController.navigate("PantallaDetallesPaqueteriaCelador")
            }
            PaqueteItem(nombre = "Paquete 2", torre = " ", apto = " ") {
                navController.navigate("PantallaDetallesPaqueteriaCelador")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))


        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.CheckBox ,
                contentDescription = null,
                tint = DoradoElegante,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Paquetes Entregados",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PaqueteItem(nombre = "Paquete 3", torre = " ", apto = " ") {
                navController.navigate("PantallaDetallesPaqueteriaCelador")
            }
            PaqueteItem(nombre = "Paquete 4", torre = " ", apto = " ") {
                navController.navigate("PantallaDetallesPaqueteriaCelador")
            }
        }
    }
}

@Composable
fun PaqueteItem(nombre: String, torre: String, apto: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White.copy(alpha = 0.05f))
            .clickable { onClick() }
            .padding(12.dp)
            .width(150.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Inventory, // Ícono de caja
            contentDescription = null,
            tint = DoradoElegante,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(nombre, color = Color.White, fontWeight = FontWeight.Bold)
        Text("$torre - $apto", color = Color.LightGray, fontSize = 12.sp)
    }
}