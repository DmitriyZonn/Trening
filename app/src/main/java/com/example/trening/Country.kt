package com.example.trening

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    @SerializedName("country") val name: String,
    val cases: Long,
    val deaths: Long,
    val recovered: Long
): Parcelable