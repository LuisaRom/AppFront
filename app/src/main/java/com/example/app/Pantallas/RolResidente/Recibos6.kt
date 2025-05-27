package com.example.app.Pantallas.RolResidente

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.app.R
import androidx.navigation.NavController
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.GrisClaro

val ColorScheme.doradoElegante: Color
    @Composable
    get() = Color(0xFFD4AF37)

@Composable
fun PantallaRecibos(navController: NavController) {

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

            Text("Recibos", color = Color.White, fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Aviso Facturación", color = Color.White)

        Spacer(modifier = Modifier.height(16.dp))

        listOf(
            Pair(R.drawable.logoenel, true),
            Pair(R.drawable.logovanti, false),
            Pair(R.drawable.logoepz, false)
        ).forEach { (logo, disponible) ->

            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = logo),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .size(35.dp)
                        .background(
                            color = if (disponible) MaterialTheme.colorScheme.doradoElegante else Color.LightGray ,
                            shape = CircleShape
                        )
                )
            }
        }
    }
}