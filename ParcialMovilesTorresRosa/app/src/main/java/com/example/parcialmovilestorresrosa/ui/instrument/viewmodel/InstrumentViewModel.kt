package com.example.parcialmovilestorresrosa.ui.instrument.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcialmovilestorresrosa.InstrumentReviewerApplication
import com.example.parcialmovilestorresrosa.data.model.InstrumentModel
import com.example.parcialmovilestorresrosa.repository.InstrumentRepository

class InstrumentViewModel(private val repository: InstrumentRepository) : ViewModel() {

    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var status = MutableLiveData("")
    fun getInstruments() = repository.getInstruments()

    fun addInstruments(instrument: InstrumentModel) = repository.addInstruments(instrument)

    fun createInstrument() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val instrument = InstrumentModel(
            name.value!!,
            category.value!!,
        )

        addInstruments(instrument)
        clearData()

        status.value = INSTRUMENT_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false

        }
        return true
    }

    fun clearData() {
        name.value = ""
        category.value = ""

    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedInstrument(movie: InstrumentModel) {
        name.value = movie.name
        category.value = movie.category

    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as InstrumentReviewerApplication
                InstrumentViewModel(app.instrumentRepository)
            }
        }

        const val INSTRUMENT_CREATED = "Instrument created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }

}