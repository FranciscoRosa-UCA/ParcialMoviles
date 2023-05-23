package com.example.parcialmovilestorresrosa.repository

import com.example.parcialmovilestorresrosa.data.model.InstrumentModel

class InstrumentRepository(private val instruments: MutableList<InstrumentModel>) {

    fun getInstruments() = instruments

    fun addInstruments(instrument: InstrumentModel) = instruments.add(instrument)

}