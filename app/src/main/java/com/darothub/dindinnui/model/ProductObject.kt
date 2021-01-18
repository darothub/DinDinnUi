package com.darothub.dindinnui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductObject(
    val id: Long,
    val image: String,
    val title: String,
    val description: String,
    val weight: String,
    val price: String
) : Parcelable
