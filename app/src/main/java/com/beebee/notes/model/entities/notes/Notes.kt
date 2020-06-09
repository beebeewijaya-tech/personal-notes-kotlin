package com.beebee.notes.model.entities.notes

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "notes")
data class Notes (
	@PrimaryKey(autoGenerate = true)
	val uuid: Int = 0,
	val title: String,
	val description: String
)
