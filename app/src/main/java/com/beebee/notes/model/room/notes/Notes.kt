package com.beebee.notes.model.room.notes

import com.beebee.notes.database.Connector
import com.beebee.notes.model.pojo.notes.Notes as PojoNotes
import com.beebee.notes.model.entities.notes.Notes as EntitiesNotes
import com.beebee.notes.util.base.Application
import javax.inject.Inject

class RoomNotes @Inject constructor() : INotes {
	private var databaseClient = Connector.getInstance(Application.instance.applicationContext)

	override fun getListNotes(): List<PojoNotes> = databaseClient.notesDao().retrieveNotes()

	override fun getFakeNotes(): List<PojoNotes> = getListNotes()

	override fun addNotes(notes: EntitiesNotes) = databaseClient.notesDao().addNotes(notes)
}