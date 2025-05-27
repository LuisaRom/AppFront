package com.example.app.Pantallas.RolResidente

import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.Icon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.DoradoElegante
import com.example.app.ui.theme.GrisClaro

@Composable
fun PantallaNotificacionesResidente(navController: NavController) {
    val context = LocalContext.current
    var selectedTab by remember { mutableStateOf("Paqueteria") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AzulOscuro)
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                tint = GrisClaro,
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Notificaciones", color = Color.White, fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("Paqueteria", "Recibos", "Pagos").forEach { tab ->
                val isSelected = selectedTab == tab
                Button(
                    onClick = {
                        selectedTab = tab
                        when (tab) {
                            "Recibos" -> navController.navigate("PantallaRecibos")
                            "Pagos" -> navController.navigate("PantallaPagos")
                        }
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) DoradoElegante else Color.Gray
                    )
                ) {
                    Text(tab)
                }
            }
        }

        if (selectedTab == "Paqueteria") {
            Spacer(modifier = Modifier.height(24.dp))
            Text("Paquete Nuevo", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            EtiquetaCampo("Id", " ")
            EtiquetaCampo("Transportadora", " ")
            EtiquetaCampo("Fecha", " ")
            EtiquetaCampo("Nombre", " ")

            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    Toast.makeText(context, "Paquete recibido", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DoradoElegante)
            ) {
                Text("Recibido", color = Color.White)
            }
        }
    }
}

@Composable
fun EtiquetaCampo(label: String, valor: String) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = label, color = GrisClaro, fontSize = 12.sp)
        Text(
            text = valor,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White.copy(alpha = 0.05f), RoundedCornerShape(6.dp))
                .padding(12.dp)
        )
    }
}