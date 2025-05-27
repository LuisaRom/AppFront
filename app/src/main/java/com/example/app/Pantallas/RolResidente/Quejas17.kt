package com.example.app.Pantallas.RolResidente

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.DoradoElegante
import com.example.app.ui.theme.GrisClaro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaQuejasResidente(navController: NavController) {
    val context = LocalContext.current

    var torreApto by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var mensaje by remember { mutableStateOf("") }

    val opcionesTipo = listOf("Ruido", "Violencia", "Mascota")

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
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Quejas",
                style = MaterialTheme.typography.headlineSmall,
                color = GrisClaro
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Torre y Apartamento", color = Color.White)
        OutlinedTextField(
            value = torreApto,
            onValueChange = { torreApto = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = AzulOscuro,
                focusedBorderColor = DoradoElegante,
                unfocusedBorderColor = GrisClaro,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("Fecha", color = Color.White)
        OutlinedTextField(
            value = fecha,
            onValueChange = { fecha = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = { Text("dd/mm/aaaa") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = AzulOscuro,
                focusedBorderColor = DoradoElegante,
                unfocusedBorderColor = GrisClaro,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("Tipo", color = Color.White)
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                readOnly = true,
                value = tipo,
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
                opcionesTipo.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion) },
                        onClick = {
                            tipo = opcion
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Mensaje", color = Color.White)
        OutlinedTextField(
            value = mensaje,
            onValueChange = { mensaje = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = AzulOscuro,
                focusedBorderColor = DoradoElegante,
                unfocusedBorderColor = GrisClaro,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                Toast.makeText(context, "Queja creada con exito", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DoradoElegante)
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Text("Crear Queja", color = AzulOscuro, fontWeight = FontWeight.Bold)
        }
    }
}