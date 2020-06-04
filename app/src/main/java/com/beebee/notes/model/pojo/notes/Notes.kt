package com.beebee.notes.model.pojo.notes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Notes (
	val title: String,
	val description: String
): Parcelable
