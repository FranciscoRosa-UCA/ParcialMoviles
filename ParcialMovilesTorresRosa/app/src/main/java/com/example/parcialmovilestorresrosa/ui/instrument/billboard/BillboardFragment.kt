package com.example.parcialmovilestorresrosa.ui.instrument.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcialmovilestorresrosa.R
import com.example.parcialmovilestorresrosa.data.model.InstrumentModel
import com.example.parcialmovilestorresrosa.databinding.FragmentBillboardBinding
import com.example.parcialmovilestorresrosa.ui.instrument.billboard.recyclerview.InstrumentRecyclerViewAdapter
import com.example.parcialmovilestorresrosa.ui.instrument.viewmodel.InstrumentViewModel


class BillboardFragment : Fragment() {


    private val instrumentViewModel: InstrumentViewModel by activityViewModels {
        InstrumentViewModel.Factory
    }

    private lateinit var adapter: InstrumentRecyclerViewAdapter

    private lateinit var binding: FragmentBillboardBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnNavCreateNewInstrument.setOnClickListener {
            instrumentViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newInstrumentFragment)
        }

    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = InstrumentRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.recyclerView.adapter = adapter
        displayMovies()
    }

    private fun displayMovies() {
        adapter.setData(instrumentViewModel.getInstruments())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(instrument: InstrumentModel) {
        instrumentViewModel.setSelectedInstrument(instrument)
        findNavController().navigate(R.id.action_billboardFragment_to_instrumentFragment)
    }
}