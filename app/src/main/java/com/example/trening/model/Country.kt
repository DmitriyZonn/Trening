package com.example.trening.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val country: String,
    val cases: Long,
    val deaths: Long,
    val recovered: Long
): Parcelable