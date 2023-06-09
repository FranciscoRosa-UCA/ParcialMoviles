package com.example.parcialmovilestorresrosa.ui.instrument

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.parcialmovilestorresrosa.R
import com.example.parcialmovilestorresrosa.databinding.FragmentInstrumentBinding
import com.example.parcialmovilestorresrosa.ui.instrument.viewmodel.InstrumentViewModel


class InstrumentFragment : Fragment() {

    private val movieViewModel: InstrumentViewModel by activityViewModels {
        InstrumentViewModel.Factory
    }

    private lateinit var binding: FragmentInstrumentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstrumentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }

}