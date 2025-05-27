package com.example.app.Pantallas.RolCelador

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
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
fun PantallaPerfilCelador(navController: NavController) {
    val context = LocalContext.current

    var nombre by remember { mutableStateOf("Luisa Fernanda Romero") }
    var usuario by remember { mutableStateOf("LuRomero") }
    var contraseña by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("Activo") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AzulOscuro)
            .padding(16.dp)
    ) {
        // Botón volver
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                tint = GrisClaro,
                modifier = Modifier
                    .clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Perfil",
                style = MaterialTheme.typography.headlineSmall,
                color = GrisClaro
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Ícono de perfil
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Perfil",
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally),
            tint = Color.White
        )

        Text(
            text = usuario,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        CampoPerfil("Nombre", nombre) { nombre = it }
        CampoPerfil("Usuario", usuario) { usuario = it }
        CampoPerfil("Contraseña", contraseña) { contraseña = it }
        CampoPerfil("Estado", estado) { estado = it }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                Toast.makeText(context, "Sesion Cerrada", Toast.LENGTH_SHORT).show()
                // redirijir  navController.navigate("PantallaInicioRolCelador")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DoradoElegante)
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Text("Cerrar Sseion ", color = AzulOscuro, fontWeight = FontWeight.Bold)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoPerfil(label: String, valor: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = valor,
        onValueChange = onValueChange,
        label = { Text(label, color = Color.LightGray) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
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