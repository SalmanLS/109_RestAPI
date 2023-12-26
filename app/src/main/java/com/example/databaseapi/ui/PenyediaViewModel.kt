package com.example.databaseapi.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.databaseapi.KontakAplikasi
import com.example.databaseapi.ui.home.viewmodel.HomeViewModel
import com.example.databaseapi.ui.kontak.viewmodel.InsertViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiKontak().container.kontakRepository) }

        initializer { InsertViewModel(aplikasiKontak().container.kontakRepository) }
    }

}

fun CreationExtras.aplikasiKontak() : KontakAplikasi =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KontakAplikasi)