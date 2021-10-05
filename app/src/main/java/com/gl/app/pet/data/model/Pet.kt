package com.gl.app.pet.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * @author Kevin Villalobos
 */
@Keep
@Parcelize
data class Pet(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("breed")
    val breed: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("pet_image")
    val petImage: String,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("color")
    val color: String? = null
) : Parcelable
