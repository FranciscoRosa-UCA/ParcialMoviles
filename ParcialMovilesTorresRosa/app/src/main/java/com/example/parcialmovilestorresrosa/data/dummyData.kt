package com.example.parcialmovilestorresrosa.data

import com.example.parcialmovilestorresrosa.data.model.InstrumentModel

val name1 = "Guitarra"
val category1 = "Instrumento de cuerda"

val name2 = "Piano"
val category2 = "Instrumento de teclas"

var instruments = mutableListOf(
    InstrumentModel(name1, category1),
    InstrumentModel(name2, category2)
)