package com.example.parcialmovilestorresrosa

import android.app.Application
import com.example.parcialmovilestorresrosa.data.instruments
import com.example.parcialmovilestorresrosa.repository.InstrumentRepository

class InstrumentReviewerApplication: Application() {
    val instrumentRepository: InstrumentRepository by lazy {
        InstrumentRepository(instruments)
    }
}