package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.gastodeviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.grayDracula                                                                                                                                                                )
        setListeners()
    }

    private fun setListeners() {
        binding.buttonCalcular.setOnClickListener {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        if (binding.editTotalKm.text.isEmpty() && binding.editTotalKm.text.isBlank()) {
            return false
        } else if (binding.editAutonomia.text.isEmpty() && binding.editAutonomia.text.isBlank()) {
            return false
        } else if (binding.editPrecoLitro.text.isEmpty() && binding.editPrecoLitro.text.isBlank()) {
            return false
        }

        return  true
    }

    private fun calculate() {
        if (isValid()) {
            val distance = binding.editTotalKm.text.toString().toFloat()
            val price = binding.editPrecoLitro.text.toString().toFloat()
            val autonomy = binding.editAutonomia.text.toString().toFloat()
            val totalValue = (distance * price) / autonomy
            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        } else {
            Toast.makeText(this, R.string.preencha_campos, Toast.LENGTH_LONG)
                .show()
        }

    }
}