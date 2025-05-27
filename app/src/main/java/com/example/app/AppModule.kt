package com.example.app

import com.example.app.Interfaces.RetrofitClient.RetrofitClient
import com.example.app.Interfaces.UsuarioApiService
import com.example.app.Repository.UsuarioRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUsuarioApiService(): UsuarioApiService {
        return RetrofitClient.usuarioApiService
    }

    @Provides
    @Singleton
    fun provideUsuarioRepository(
        api: UsuarioApiService
    ): UsuarioRepository = UsuarioRepository(api)
}