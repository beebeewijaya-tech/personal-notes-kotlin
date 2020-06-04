package com.beebee.notes.model.room.notes

import com.beebee.notes.model.pojo.notes.Notes

interface INotes {
	fun getFakeNotes(): List<Notes>
}