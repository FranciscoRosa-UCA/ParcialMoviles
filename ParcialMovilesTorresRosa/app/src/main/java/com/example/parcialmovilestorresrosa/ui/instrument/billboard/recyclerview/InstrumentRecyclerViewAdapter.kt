package com.example.parcialmovilestorresrosa.ui.instrument.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialmovilestorresrosa.data.model.InstrumentModel
import com.example.parcialmovilestorresrosa.databinding.InstrumentItemBinding

class InstrumentRecyclerViewAdapter(
    private val clickListener: (InstrumentModel) -> Unit
) : RecyclerView.Adapter<InstrumentRecyclerViewHolder>()  {
    private val movies = ArrayList<InstrumentModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstrumentRecyclerViewHolder {
        val binding = InstrumentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InstrumentRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: InstrumentRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    fun setData(moviesList: List<InstrumentModel>) {
        movies.clear()
        movies.addAll(moviesList)
    }
}