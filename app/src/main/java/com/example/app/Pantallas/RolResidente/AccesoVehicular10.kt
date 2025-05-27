package com.example.app.Pantallas.RolResidente

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaAccesoVehicularResidente(navController: NavController) {
    val context = LocalContext.current
    var torreApto by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var horario by remember { mutableStateOf("") }
    var tipoVehiculo by remember { mutableStateOf("") }
    var placa by remember { mutableStateOf("") }
    var quienIngresa by remember { mutableStateOf("") }
    var quienAutoriza by remember { mutableStateOf("") }

    val opcionesVehiculo = listOf("Automóvil", "Camioneta", "Moto", "Eléctrico")
    var expanded by remember { mutableStateOf(false) }

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
            Text("Acceso Vehicular", color = GrisClaro, style = MaterialTheme.typography.headlineSmall)
        }

        Spacer(modifier = Modifier.height(24.dp))

        CampoAcceso("Torre - Apartamento", torreApto) { torreApto = it }
        CampoAcceso("Fecha", fecha) { fecha = it }
        CampoAcceso("Horario", horario) { horario = it }

        Text("Tipo de Vehículo", color = Color.White)

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                readOnly = true,
                value = tipoVehiculo,
                onValueChange = {},
                label = { Text("Selecciona el tipo") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = AzulOscuro,
                    focusedBorderColor = DoradoElegante,
                    unfocusedBorderColor = GrisClaro,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                opcionesVehiculo.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion) },
                        onClick = {
                            tipoVehiculo = opcion
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        CampoAcceso("Placa", placa) { placa = it }
        CampoAcceso("¿Quién ingresa?", quienIngresa) { quienIngresa = it }
        CampoAcceso("¿Quién autoriza?", quienAutoriza) { quienAutoriza = it }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                Toast.makeText(context, "Acceso vehicular creado", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DoradoElegante)
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Text("Crear Acceso", color = AzulOscuro, fontWeight = FontWeight.Bold)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoAcceso(label: String, valor: String, onChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = label, color = Color.LightGray, fontSize = 12.sp)
        OutlinedTextField(
            value = valor,
            onValueChange = onChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = DoradoElegante,
                unfocusedBorderColor = GrisClaro,
                cursorColor = DoradoElegante,
                focusedLabelColor = GrisClaro,
                unfocusedLabelColor = GrisClaro,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )
    }
}