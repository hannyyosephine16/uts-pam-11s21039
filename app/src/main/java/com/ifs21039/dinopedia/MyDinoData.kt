package com.ifs21039.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class MyDinoData(
    var dinoName: String,
    var dinoIcon: Int,
    var dinoDescription: String,
    var dinoCharacteristic: String,
    var dinoGroup: String,
    var dinoHabitat: String,
    var dinoFood: String,
    var dinoLength: String,
    var dinoHeight: String,
    var dinoWeight: String,
    var dinoWeakness: String,
) : Parcelable

