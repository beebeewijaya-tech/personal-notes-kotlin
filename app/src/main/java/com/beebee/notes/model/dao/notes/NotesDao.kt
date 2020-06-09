package com.beebee.notes.model.dao.notes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.beebee.notes.model.pojo.notes.Notes as PojoNotes
import com.beebee.notes.model.entities.notes.Notes as EntitiesNotes

@Dao
interface NotesDao {
	@Query("SELECT * FROM notes")
	fun retrieveNotes(): List<PojoNotes>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun addNotes(notes: EntitiesNotes)
}