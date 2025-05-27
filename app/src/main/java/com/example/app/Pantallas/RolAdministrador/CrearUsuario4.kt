package com.example.app.Pantallas.RolAdministrador

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.DoradoElegante
import com.example.app.ui.theme.GrisClaro
import kotlinx.coroutines.launch

@Composable
fun PantallaCrearUsuario(navController: NavHostController) {
    var nombre by remember { mutableStateOf("") }
    var cedula by remember { mutableStateOf("") }
    var torre by remember { mutableStateOf("") }
    var apartamento by remember { mutableStateOf("") }
    var numHabitantes by remember { mutableStateOf("") }
    var vehiculo by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        containerColor = AzulOscuro
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(32.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Crear Usuario",
                color = GrisClaro,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre completo") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = cedula,
                onValueChange = { cedula = it },
                label = { Text("Cédula") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = torre,
                onValueChange = { torre = it },
                label = { Text("Torre") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = apartamento,
                onValueChange = { apartamento = it },
                label = { Text("Apartamento") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = numHabitantes,
                onValueChange = { numHabitantes = it },
                label = { Text("Número de habitantes") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "¿Tiene vehículo?",
                    color = GrisClaro,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Switch(
                    checked = vehiculo,
                    onCheckedChange = { vehiculo = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = DoradoElegante
                    )
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Usuario creado exitosamente")
                    }
                    // Aquí puedes agregar lógica para enviar los datos al servidor
                },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DoradoElegante),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text(
                    text = "Crear",
                    fontSize = 18.sp,
                    color = AzulOscuro
                )
            }
        }
    }
}
