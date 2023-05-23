package com.example.parcialmovilestorresrosa.ui.instrument.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.parcialmovilestorresrosa.data.model.InstrumentModel
import com.example.parcialmovilestorresrosa.databinding.InstrumentItemBinding

class InstrumentRecyclerViewHolder(private val binding: InstrumentItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(instrument: InstrumentModel, clickListener: (InstrumentModel) -> Unit) {
        binding.titleTextView.text = instrument.name
        binding.categoryTextView.text = instrument.category

        binding.movieItemCardView.setOnClickListener {
            clickListener(instrument)
        }
    }
}