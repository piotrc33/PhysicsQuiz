package com.example.quiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

val questionsAnswers = arrayOf(
    "Is sun bigger than earth?" to true,
    "Is water liquid in 101 C degrees" to false,
    )

var points: Int = 0
var correctAnswers: Int = 0
var cheats: Int = 0
var questionNum: Int = 0
lateinit var questionNAnswer : Pair<String, Boolean>
var answer: Boolean? = null

class MainActivity : AppCompatActivity() {
    private val trueButton: Button by lazy{findViewById(R.id.trueButton)}
    private val falseButton: Button by lazy{findViewById(R.id.falseButton)}
    private val cheatButton: Button by lazy{findViewById(R.id.cheatButton)}
    private val questionTextView: TextView by lazy{findViewById(R.id.question)}
    private val pointsTextView: TextView by lazy{findViewById(R.id.total_points)}
    private val correctAnswersTextView: TextView by lazy{findViewById(R.id.correct_answers)}
    private val cheatsTextView: TextView by lazy{findViewById(R.id.total_cheats)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionNAnswer = questionsAnswers[questionNum]
        questionTextView.text = questionNAnswer.first
        answer = questionNAnswer.second

        var (question, answer) = questionsAnswers[questionNum]
        questionTextView.text = question
        // Application adding points only on true button click
        trueButton.setOnClickListener() {
            if (answer) {
                points += 10
                correctAnswers++
            }
            answer = nextQuestion()
        }
        falseButton.setOnClickListener() {
            if (!answer) {
                points += 10
                correctAnswers++
            }
            answer = nextQuestion()
        }
        cheatButton.setOnClickListener() {
            goToCheatActivity()
            points -= 15
            cheats++
        }
    }

    private fun nextQuestion() : Boolean {
        if(questionNum + 1 < questionsAnswers.size)
        {
            questionNum += 1
            questionNAnswer = questionsAnswers[questionNum]
            questionTextView.text = questionNAnswer.first
            answer = questionNAnswer.second
            return answer as Boolean
        }
        else {
            showStats()
            return false
        }

    }

    private fun goToCheatActivity() {
        val intent = Intent(this@MainActivity, CheatActivity::class.java)
        startActivity(intent) // no idea which is better
    }

    private fun showStats() {
        questionTextView.text = "You answered all the questions!"
        cheatButton.visibility = View.GONE
        trueButton.visibility = View.GONE
        falseButton.visibility = View.GONE
        val pointsText : String = "Points: " + points.toString()
        val correctAnswersText : String = "Correct answers: " + correctAnswers.toString()
        val cheatsText : String = "Number of cheats: " + cheats.toString()
        pointsTextView.text = pointsText
        correctAnswersTextView.text = correctAnswersText
        cheatsTextView.text = cheatsText
    }

}