package com.example.parcialmovilestorresrosa.ui.instrument

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcialmovilestorresrosa.R
import com.example.parcialmovilestorresrosa.data.model.InstrumentModel
import com.example.parcialmovilestorresrosa.databinding.FragmentNewInstrumentBinding


class NewInstrumentFragment : Fragment() {

    private val instrumentViewModel: InstrumentViewModel by activityViewModels {
        InstrumentViewModel.Factory
    }

    private lateinit var binding: FragmentNewInstrumentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewInstrumentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = instrumentViewModel
    }

    private fun observeStatus() {
        instrumentViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(InstrumentViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    instrumentViewModel.clearStatus()
                }
                status.equals(InstrumentViewModel.INSTRUMENT_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, instrumentViewModel.getInstruments().toString())

                    instrumentViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object {
        const val APP_TAG = "APP TAG"
    }
}