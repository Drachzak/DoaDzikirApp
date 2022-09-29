package com.dzak.doadandzikir.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Artikel(
    var titleArtikel: String,
    var descArtikel: String,
    var imageArtikel: Int
) : Parcelable
