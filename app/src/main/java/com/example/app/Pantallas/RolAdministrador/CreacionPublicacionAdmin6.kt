package com.example.app.Pantallas.RolAdministrador

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.DoradoElegante
import com.example.app.ui.theme.GrisClaro
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text

@Composable
fun PantallaCreacionPublicacionAdmin(navController: NavController) {
    var descripcion by remember { mutableStateOf("") }
    var imagenSeleccionada by remember { mutableStateOf("https://via.placeholder.com/300x300") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AzulOscuro
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver",
                        tint = Color.White
                    )
                }
                Text(
                    text = "Creación Publicación",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = rememberAsyncImagePainter("https://randomuser.me/api/portraits/women/1.jpg"),
                    contentDescription = "Perfil",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(start = 12.dp)) {
                    Text("Nombre Usuario", color = Color.White, fontWeight = FontWeight.Bold)
                    Text("Torre - Apto", color = GrisClaro, fontSize = 12.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = rememberAsyncImagePainter(imagenSeleccionada),
                contentDescription = "Imagen Seleccionada",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))


            OutlinedTextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text("Descripción de la publicación") },
                modifier = Modifier.fillMaxWidth(),
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

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf(
                    Icons.Default.Person to "Etiqueta",
                    Icons.Default.Image to "Galería",
                    Icons.Default.VideoLibrary to "Video",
                    Icons.Default.PhotoCamera to "Cámara"
                ).forEach { (icon, desc) ->
                    IconButton(onClick = { /* acción */ }) {
                        Icon(icon, contentDescription = desc, tint = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Botón compartir
            Button(
                onClick = { /* lógica compartir */ },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DoradoElegante),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text("Compartir", color = AzulOscuro, fontSize = 16.sp)
            }
        }
    }
}

