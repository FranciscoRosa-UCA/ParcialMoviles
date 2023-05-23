package com.example.parcialmovilestorresrosa.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parcialmovilestorresrosa.R
import com.example.parcialmovilestorresrosa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}