package com.example.app

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.app.Pantallas.PantallaLogin
import com.example.app.Pantallas.PantallaSeleccionRol
import com.example.app.Pantallas.RolAdministrador.PantallaAccesoPeatonalDetalle
import com.example.app.Pantallas.RolAdministrador.PantallaAccesoVehicularDetalle
import com.example.app.Pantallas.RolAdministrador.PantallaAccesos
import com.example.app.Pantallas.RolAdministrador.PantallaCreacionPublicacionAdmin
import com.example.app.Pantallas.RolAdministrador.PantallaCrearUsuario
import com.example.app.Pantallas.RolAdministrador.PantallaDashboardAdmin
import com.example.app.Pantallas.RolAdministrador.PantallaDetalleQuejas
import com.example.app.Pantallas.RolAdministrador.PantallaDetalleReservaPiscina
import com.example.app.Pantallas.RolAdministrador.PantallaDetalleReservaSalonComunal
import com.example.app.Pantallas.RolAdministrador.PantallaDetalleReservaZonaBBQ
import com.example.app.Pantallas.RolAdministrador.PantallaInicioAdmin
import com.example.app.Pantallas.RolAdministrador.PantallaMascotas
import com.example.app.Pantallas.RolAdministrador.PantallaMensajes
import com.example.app.Pantallas.RolAdministrador.PantallaMenu
import com.example.app.Pantallas.RolAdministrador.PantallaPerfil
import com.example.app.Pantallas.RolAdministrador.PantallaQuejas
import com.example.app.Pantallas.RolAdministrador.PantallaReservas
import com.example.app.Pantallas.RolCelador.PantallaAccesoPeatonalCelador
import com.example.app.Pantallas.RolCelador.PantallaAccesoVehicularCelador
import com.example.app.Pantallas.RolCelador.PantallaAccesosCelador
import com.example.app.Pantallas.RolCelador.PantallaDashboardCelador
import com.example.app.Pantallas.RolCelador.PantallaDetalleQuejasCelador
import com.example.app.Pantallas.RolCelador.PantallaMascotasCelador
import com.example.app.Pantallas.RolCelador.PantallaMenuCelador
import com.example.app.Pantallas.RolCelador.PantallaPerfilCelador
import com.example.app.Pantallas.RolCelador.PantallaQuejasCelador
import com.example.app.Pantallas.RolCelador.PantallaRecibosCelador
import com.example.app.Pantallas.RolCelador.PantallaReservaPiscinaCelador
import com.example.app.Pantallas.RolCelador.PantallaReservaSalonComunalCelador
import com.example.app.Pantallas.RolCelador.PantallaReservaZonaBBQCelador
import com.example.app.Pantallas.RolCelador.PantallaReservasCelador
import com.example.app.Pantallas.RolResidente.PantallaAccesoPeatonalResidente
import com.example.app.Pantallas.RolResidente.PantallaAccesoVehicularResidente
import com.example.app.Pantallas.RolResidente.PantallaAccesosResidente
import com.example.app.Pantallas.RolResidente.PantallaInicioResidentes
import com.example.app.Pantallas.RolResidente.PantallaMascotasResidente
import com.example.app.Pantallas.RolResidente.PantallaMenuResidente
import com.example.app.Pantallas.RolResidente.PantallaNotificacionesResidente
import com.example.app.Pantallas.RolResidente.PantallaNuevaPublicacion
import com.example.app.Pantallas.RolResidente.PantallaPagos
import com.example.app.Pantallas.RolResidente.PantallaPerfilResidente
import com.example.app.Pantallas.RolResidente.PantallaQuejasResidente
import com.example.app.Pantallas.RolResidente.PantallaRecibos
import com.example.app.Pantallas.RolResidente.PantallaReservaGimnasio
import com.example.app.Pantallas.RolResidente.PantallaReservaPiscina
import com.example.app.Pantallas.RolResidente.PantallaReservaSalonComunal
import com.example.app.Pantallas.RolResidente.PantallaReservaZonaBBQ
import com.example.app.Pantallas.RolResidente.PantallaReservasResidente
import com.example.app.ViewModel.UsuarioViewModel

@Composable
fun Navegacion(navController: NavHostController) {
    val usuarioViewModel: UsuarioViewModel = hiltViewModel()

    NavHost(navController, startDestination = "PantallaSeleccionRol") {
        composable("PantallaSeleccionRol") {
            PantallaSeleccionRol(navController, usuarioViewModel)
        }
        composable("PantallaLogin") {
            PantallaLogin(navController, usuarioViewModel)
        }
        composable("PantallaInicioAdmin") {
            PantallaInicioAdmin(navController)
        }
        composable("PantallaDashboardCelador") {
            PantallaDashboardCelador(navController)
        }
        composable("PantallaInicioResidentes") {
            PantallaInicioResidentes(navController)
        }

        // ADMINISTRADOR
        //2
        composable("PantallaInicioAdmin") {
            PantallaInicioAdmin(navController)
        }

        //3
        composable("PantallaCrearUsuario") {
            PantallaCrearUsuario(navController)
        }

        //4
        composable("PantallaDashboardAdmin") {
            PantallaDashboardAdmin(navController)
        }

        //5
        composable("PantallaCreacionPublicacionAdmin") {
            PantallaCreacionPublicacionAdmin(navController)
        }

        //6
        composable("PantallaMensajes/{nombre}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            PantallaMensajes(nombre = nombre, navController = navController)
        }

        //7
        composable("PantallaMenu") {
            PantallaMenu(navController)
        }

        //8
        composable("PantallaAccesos") {
            PantallaAccesos(navController)
        }

        //9i
        composable("PantallaAccesoVehicularDetalle") {
            PantallaAccesoVehicularDetalle(navController)
        }

        //10
        composable("PantallaAccesoPeatonalDetalle") {
            PantallaAccesoPeatonalDetalle(navController)
        }

        //11
        composable("PantallaReservas") {
            PantallaReservas(navController)
        }

        //12
        composable("PantallaDetalleReservaPiscina") {
            PantallaDetalleReservaPiscina(navController)
        }

        //13
        composable("PantallaDetalleReservaSalonComunal") {
            PantallaDetalleReservaSalonComunal(navController)
        }

        //14
        composable("PantallaDetalleReservaZonaBBQ") {
            PantallaDetalleReservaZonaBBQ(navController)
        }

        //15
        composable("PantallaQuejas") {
            PantallaQuejas(navController)
        }

        //16
        composable("PantallaDetalleQuejas") {
            PantallaDetalleQuejas(navController)
        }

        //17
        composable("PantallaMascotas") {
            PantallaMascotas(navController)
        }

        //18
        composable("PantallaPerfil") {
            PantallaPerfil(navController)
        }

        //RESIDENTE


        //2
        composable("PantallaInicioResidentes") {
            PantallaInicioResidentes(navController)
        }

        //3
        composable("PantallaNuevaPublicacion") {
            PantallaNuevaPublicacion(navController)
        }

        //4
        composable("PantallaNotificacionesResidente") {
            PantallaNotificacionesResidente(navController)
        }

        //5
        composable("PantallaRecibos") {
            PantallaRecibos(navController)
        }

        //6
        composable("PantallaPagos") {
            PantallaPagos(navController)
        }

        //7
        composable("PantallaMenuResidente") {
            PantallaMenuResidente(navController)
        }

        //8
        composable("PantallaAccesosResidente") {
            PantallaAccesosResidente(navController)
        }

        //9
        composable("PantallaAccesoVehicularResidente") {
            PantallaAccesoVehicularResidente(navController)
        }

        //10
        composable("PantallaAccesoPeatonalResidente") {
            PantallaAccesoPeatonalResidente(navController)
        }

        //11
        composable("PantallaReservasResidente") {
            PantallaReservasResidente(navController)
        }

        //12
        composable("PantallaReservaPiscina") {
            PantallaReservaPiscina(navController)
        }

        //13
        composable("PantallaReservaSalonComunal") {
            PantallaReservaSalonComunal(navController)
        }

        //14
        composable("PantallaReservaGimnasio") {
            PantallaReservaGimnasio(navController)
        }

        //15
        composable("PantallaReservaZonaBBQ") {
            PantallaReservaZonaBBQ(navController)
        }

        //16
        composable("PantallaQuejasResidente") {
            PantallaQuejasResidente(navController)
        }

        //17
        composable("PantallaMascotasResidente") {
            PantallaMascotasResidente(navController)
        }

        //18
        composable("PantallaPerfilResidente") {
            PantallaPerfilResidente(navController)
        }

        //CELADOR

        //2
        composable("PantallaDashboardCelador") {
            PantallaDashboardCelador(navController)
        }

        //3
        /*composable("PantallaNotificacionesCelador") {
            PantallaNotificacionesCelador(navController)
        }

        composable("PantallaMensajesCelador") {
            PantallaMensajesCelador(navController)
        }

        composable("PantallaPaqueteriaCelador") {
            PantallaPaqueteriaCelador(navController)
        }

        composable("PantallaDetallesPaqueteriaCelador") {
            PantallaDetallesPaqueteriaCelador(navController)
        }*/

        //7
        composable("PantallaRecibosCelador") {
            PantallaRecibosCelador(navController)
        }

        //8
        composable("PantallaMenuCelador") {
            PantallaMenuCelador(navController)
        }

        //9
        composable("PantallaAccesosCelador") {
            PantallaAccesosCelador(navController)
        }

        //10
        composable("PantallaAccesoVehicularCelador") {
            PantallaAccesoVehicularCelador(navController)
        }

        //11
        composable("PantallaAccesoPeatonalCelador") {
            PantallaAccesoPeatonalCelador(navController)
        }

        //12
        composable("PantallaReservasCelador") {
            PantallaReservasCelador(navController)
        }

        //13
        composable("PantallaReservaPiscinaCelador") {
            PantallaReservaPiscinaCelador(navController)
        }

        //14
        composable("PantallaReservaSalonComunalCelador") {
            PantallaReservaSalonComunalCelador(navController)
        }

        /*composable("PantallaReservaGimnasioCelador") {
            PantallaReservaGimnasioCelador(navController)
        }*/

        //16
        composable("PantallaReservaZonaBBQCelador") {
            PantallaReservaZonaBBQCelador(navController)
        }

        //17
        composable("PantallaQuejasCelador") {
            PantallaQuejasCelador(navController)
        }

        //18
        composable("PantallaDetalleQuejasCelador") {
            PantallaDetalleQuejasCelador(navController)
        }

        //19
        composable("PantallaMascotasCelador") {
            PantallaMascotasCelador(navController)
        }

        //20
        composable("PantallaPerfilCelador") {
            PantallaPerfilCelador(navController)
        }
    }
}


