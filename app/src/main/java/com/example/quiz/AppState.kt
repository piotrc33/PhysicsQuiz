package com.example.quiz

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class AppState(
    val points : Int,
    val correctAnswers: Int,
    val cheats: Int,
    val currentQuestion : String,
    val answer: String
    ) : Parcelable {

}