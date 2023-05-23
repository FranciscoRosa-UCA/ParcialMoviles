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


class NewInstrumentFragment : Fragment() {

    private val instrumentViewModel: InstrumentViewModel by activityViewModels {
        InstrumentViewModel.Factory
    }

    private lateinit var nameEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var submitButton: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_instrument, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind()
        submitButton.setOnClickListener {
            addInstrument()
        }
    }

    private fun bind() {
        nameEditText = view?.findViewById(R.id.name_edit_text) !!
        categoryEditText = view?.findViewById(R.id.category_edit_text) !!
        submitButton = view?.findViewById(R.id.submit_button) !!
    }

    private fun addInstrument() {

        val name = nameEditText.text.toString()
        val category = categoryEditText.text.toString()

        val instrument = InstrumentModel(name, category)

        instrumentViewModel.addInstruments(instrument)

        Log.d("NewInstrumentFragment", instrumentViewModel.getInstruments().toString())

        findNavController().popBackStack()
    }

}