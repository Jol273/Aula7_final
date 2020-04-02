package com.example.aula7_final

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Operation(val expresssion : String, val result: Double) : Parcelable