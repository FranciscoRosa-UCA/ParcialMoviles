package com.example.parcialmovilestorresrosa.ui.instrument

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcialmovilestorresrosa.InstrumentReviewerApplication
import com.example.parcialmovilestorresrosa.data.model.InstrumentModel
import com.example.parcialmovilestorresrosa.repository.InstrumentRepository

class InstrumentViewModel(private val repository: InstrumentRepository) : ViewModel() {

    fun getInstruments() = repository.getInstruments()

    fun addInstruments(instrument: InstrumentModel) = repository.addInstruments(instrument)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as InstrumentReviewerApplication
                InstrumentViewModel(app.instrumentRepository)
            }
        }
    }

}