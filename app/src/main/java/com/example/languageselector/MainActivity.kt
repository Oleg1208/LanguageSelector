package com.example.languageselector

import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var buttonSubmit: MaterialButton
    private lateinit var cardResult: CardView
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupClickListeners()
    }

    private fun initViews() {
        radioGroup = findViewById(R.id.radioGroup)
        buttonSubmit = findViewById(R.id.buttonSubmit)
        cardResult = findViewById(R.id.cardResult)
        textResult = findViewById(R.id.textResult)
    }

    private fun setupClickListeners() {
        buttonSubmit.setOnClickListener {
            handleSubmitClick()
        }
    }

    private fun handleSubmitClick() {
        val selectedId = radioGroup.checkedRadioButtonId

        if (selectedId == -1) {
            Toast.makeText(
                this,
                "Пожалуйста, выберите язык программирования",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val selectedLanguage = when (selectedId) {
            R.id.radioCpp -> "C++ - Мощный системный язык программирования"
            R.id.radioJava -> "Java - Платформонезависимый объектно-ориентированный язык"
            R.id.radioKotlin -> "Kotlin - Современный язык для Android разработки"
            R.id.radioPython -> "Python - Простой и элегантный язык программирования"
            else -> "Неизвестный язык"
        }

        showResult(selectedLanguage)

        Toast.makeText(
            this,
            "Выбор подтвержден!",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun showResult(language: String) {
        textResult.text = "Выбранный язык программирования: $language"
        cardResult.visibility = android.view.View.VISIBLE
    }
}
