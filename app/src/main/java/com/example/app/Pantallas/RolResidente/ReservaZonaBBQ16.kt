package com.example.app.Pantallas.RolResidente

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.DoradoElegante
import com.example.app.ui.theme.GrisClaro

@Composable
fun PantallaReservaZonaBBQ(navController: NavController) {
    val context = LocalContext.current

    var torreApto by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var horario by remember { mutableStateOf("") }
    var numPersonas by remember { mutableStateOf("") }
    var ingresoPeatonal by remember { mutableStateOf("") }
    var ingresoVehicular by remember { mutableStateOf("") }
    var servicios by remember { mutableStateOf("") }
    val total = "$200.000"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AzulOscuro)
            .padding(16.dp)
    ) {
        // Encabezado
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                tint = GrisClaro,
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Zona BBQ",
                style = MaterialTheme.typography.headlineSmall,
                color = GrisClaro
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Formulario
        CampoAcceso("Torre - Apartamento", torreApto) { torreApto = it }
        CampoAcceso("Fecha", fecha) { fecha = it }
        CampoAcceso("Horario", horario) { horario = it }
        CampoAcceso("Número de Personas", numPersonas) { numPersonas = it }
        CampoAcceso("Accesos Peatonales", ingresoPeatonal) { ingresoPeatonal = it }
        CampoAcceso("Accesos Vehiculares", ingresoVehicular) { ingresoVehicular = it }
        CampoAcceso("Servicios Adicionales", servicios) { servicios = it }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Total: $total", color = DoradoElegante, fontWeight = FontWeight.Bold, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                Toast.makeText(context, "Reserva zona BBQ creada", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DoradoElegante)
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Text("Crear Reserva", color = AzulOscuro, fontWeight = FontWeight.Bold)
        }
    }
}