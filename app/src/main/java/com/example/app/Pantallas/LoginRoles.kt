package com.example.app.Pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff

import com.example.app.ViewModel.UsuarioViewModel

@Composable
fun PantallaLogin(
    navController: NavHostController,
    usuarioViewModel: UsuarioViewModel
) {
    val usuarioActual by usuarioViewModel.usuarioActual.collectAsState()
    val isLoading by usuarioViewModel.isLoading.collectAsState()
    val error by usuarioViewModel.error.collectAsState()
    val rolSeleccionado by usuarioViewModel.rolSeleccionado.collectAsState()

    var usuario by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    LaunchedEffect(usuarioActual) {
        usuarioActual?.let { user ->
            println("Usuario autenticado: ${user.usuario}, Rol: ${user.rol}")

            // VALIDAR QUE EL ROL DEL USUARIO COINCIDA CON EL SELECCIONADO
            when (user.rol.uppercase()) {
                "ADMINISTRADOR" -> {
                    if (rolSeleccionado == "ADMIN") {
                        navController.navigate("PantallaInicioAdmin") {
                            popUpTo("PantallaLogin") { inclusive = true }
                        }
                    } else {
                        usuarioViewModel.clearError()
                        usuarioViewModel._error.value = "Usuario no autorizado para este rol"
                    }
                }
                "CELADOR" -> {
                    if (rolSeleccionado == "CELADOR") {
                        navController.navigate("PantallaDashboardCelador") {
                            popUpTo("PantallaLogin") { inclusive = true }
                        }
                    } else {
                        usuarioViewModel._error.value = "Usuario no autorizado para este rol"
                    }
                }
                "RESIDENTE" -> {
                    if (rolSeleccionado == "RESIDENTE") {
                        navController.navigate("PantallaInicioResidentes") {
                            popUpTo("PantallaLogin") { inclusive = true }
                        }
                    } else {
                        usuarioViewModel._error.value = "Usuario no autorizado para este rol"
                    }
                }
                else -> {
                    usuarioViewModel._error.value = "Rol de usuario no reconocido: ${user.rol}"
                }
            }
        }
    }


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF1A1A2E)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Iniciar Sesión (${rolSeleccionado ?: ""})",
                color = Color.White,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Usuario") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    usuarioViewModel.clearError() // Limpiar error al escribir
                },
                label = { Text("Contraseña") },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    val description = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña"
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = description, tint = Color.White)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { usuarioViewModel.login(usuario, password) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFDCB6E))
            ) {
                Text("Ingresar", color = Color.Black, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (isLoading) {
                CircularProgressIndicator(color = Color.White)
            }

            error?.let {
                Text(text = it, color = Color.Red, modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}