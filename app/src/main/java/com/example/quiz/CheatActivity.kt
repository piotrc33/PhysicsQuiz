package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CheatActivity : AppCompatActivity() {
    private val backButton: Button by lazy{findViewById(R.id.backButton)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        val answerText : TextView = findViewById(R.id.answer)
        showAnswer(answerText)

        backButton.setOnClickListener() {
            goToMainActivity()
        }
    }

    private fun showAnswer(answerText : TextView) {
        answerText.text = answer.toString().uppercase()
    }

    private fun goToMainActivity() {
        val intent = Intent(this@CheatActivity, MainActivity::class.java)
        startActivity(intent) // no idea which is better
    }
}