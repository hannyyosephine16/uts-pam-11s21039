package com.ifs21039.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class MyDinoFamily(
    var namaFamily: String,
    var iconFamily: Int,
) : Parcelable