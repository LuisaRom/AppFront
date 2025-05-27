package com.example.app.Pantallas.RolResidente

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.app.R
import androidx.navigation.NavController
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.DoradoElegante
import com.example.app.ui.theme.GrisClaro

@Composable
fun PantallaMascotasResidente(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var vacunaCompleta by remember { mutableStateOf(false) }

    val context = LocalContext.current

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
            Text(
                text = "Mascota",
                style = MaterialTheme.typography.headlineSmall,
                color = GrisClaro
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.perro),
            contentDescription = "Mascota",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("Nombre", color = Color.White)
        CampoBasico(valor = nombre, onValueChange = { nombre = it })

        Spacer(modifier = Modifier.height(8.dp))

        Text("Edad", color = Color.White)
        CampoBasico(valor = edad, onValueChange = { edad = it })

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("¿Vacunación completa?", color = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = vacunaCompleta,
                onCheckedChange = { vacunaCompleta = it },
                colors = SwitchDefaults.colors(checkedThumbColor = DoradoElegante)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("Descripción", color = Color.White)
        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = AzulOscuro,
                focusedBorderColor = DoradoElegante,
                unfocusedBorderColor = GrisClaro,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                Toast.makeText(context, "Publicación compartida", Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Compartir", color = Color.White)
        }
    }
}

@Composable
fun CampoBasico(valor: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = valor,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = AzulOscuro,
            focusedBorderColor = DoradoElegante,
            unfocusedBorderColor = GrisClaro,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White
        )
    )
}