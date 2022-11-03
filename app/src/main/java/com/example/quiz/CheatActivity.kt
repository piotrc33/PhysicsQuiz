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

        val state = intent.getParcelableExtra<AppState>("state")
        val ans = state?.answer
        val answerText : TextView = findViewById(R.id.answer)
        answerText.text = ans

        backButton.setOnClickListener() {
            goToMainActivity()
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}