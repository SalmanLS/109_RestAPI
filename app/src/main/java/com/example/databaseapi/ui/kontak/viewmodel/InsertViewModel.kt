package com.example.databaseapi.ui.kontak.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databaseapi.repository.KontakRepository
import kotlinx.coroutines.launch

class InsertViewModel(private val kontakRepository: KontakRepository): ViewModel() {
    var insertKontakState by mutableStateOf(InsertUiState())
        private set

    fun updateInsertKontakState(insertUiEvent: InserUiEvent){
        insertKontakState = InsertUiState(insertUiEvent = insertUiEvent)
    }

    suspend fun insertKontak(){
        viewModelScope.launch {
            try {
                kontakRepository.inserKontak(insertKontakState.insertUiEvent.toKontak())
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}


