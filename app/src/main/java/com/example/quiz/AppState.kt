package com.example.quiz

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class AppState(
    val answer: String
    ) : Parcelable {

}