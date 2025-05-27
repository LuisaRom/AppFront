package com.example.app.Pantallas.RolCelador

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.app.ui.theme.AzulOscuro


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaDetallesPaqueteriaCelador(navController: NavController) {
    val context = LocalContext.current

    var torreApto by remember { mutableStateOf("") }
    var numeroPaquete by remember { mutableStateOf("") }
    var transportadora by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    val opcionesTransportadoras = listOf(
        "Servientrega", "Coordinadora", "Interrapidísimo", "Envía", "Deprisa"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AzulOscuro)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                tint = Color.Black,
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Paqueteria", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Detalles", fontWeight = FontWeight.Bold, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))
        CampoTexto("Torre - Apartamento", torreApto) { torreApto = it }
        CampoTexto("Id", numeroPaquete) { numeroPaquete = it }

        Text("Transportadora", color = Color.Gray, fontSize = 14.sp)
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                readOnly = true,
                value = transportadora,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
                    .padding(vertical = 4.dp),
                label = { Text("Selecciona la transportadora") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                }
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                opcionesTransportadoras.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion) },
                        onClick = {
                            transportadora = opcion
                            expanded = false
                        }
                    )
                }
            }
        }

        CampoTexto("Fecha", fecha) { fecha = it }
        CampoTexto("Nombre", nombre) { nombre = it }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                Toast.makeText(context, "Notificación enviada", Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD4AF37)), // Dorado
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Enviar", color = Color.White)
        }
    }
}

@Composable
fun CampoTexto(label: String, valor: String, onValueChange: (String) -> Unit) {
    Text(label, color = Color.Gray, fontSize = 14.sp)
    OutlinedTextField(
        value = valor,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        singleLine = true
    )
}