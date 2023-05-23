package com.example.parcialmovilestorresrosa.ui.instrument

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.example.parcialmovilestorresrosa.R
import com.example.parcialmovilestorresrosa.databinding.FragmentBillboardBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class BillboardFragment : Fragment() {

    private lateinit var binding: FragmentBillboardBinding

    private lateinit var btnCreateNewInstrument: FloatingActionButton
    private lateinit var primerCV: CardView
    private lateinit var segundoCV: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCreateNewInstrument = view.findViewById(R.id.btnNavCreateNewInstrument)
        primerCV = view.findViewById(R.id.PrimerCardView)
        segundoCV = view.findViewById(R.id.SegundoCardView)

        primerCV.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_instrumentFragment)
        }

        segundoCV.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_instrumentFragment)
        }

        btnCreateNewInstrument.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_newInstrumentFragment)
        }
    }
}