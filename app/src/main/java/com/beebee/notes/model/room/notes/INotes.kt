package com.beebee.notes.model.room.notes

import com.beebee.notes.model.pojo.notes.Notes as PojoNotes
import com.beebee.notes.model.entities.notes.Notes as EntitiesNotes

interface INotes {
	fun getListNotes(): List<PojoNotes>
	fun getFakeNotes(): List<PojoNotes>
	fun addNotes(notes: EntitiesNotes)
}