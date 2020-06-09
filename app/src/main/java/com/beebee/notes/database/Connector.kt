package com.beebee.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.beebee.notes.model.dao.notes.NotesDao
import com.beebee.notes.model.entities.notes.Notes

const val DATABASE_VERSION_SCHEMA = 1
const val DATABSE_NAME = "notes_app"

@Database(version = DATABASE_VERSION_SCHEMA, entities = [Notes::class])
abstract class Connector: RoomDatabase() {

	abstract fun notesDao(): NotesDao

	companion object {
		private var databaseClient: Connector? = null

		fun getInstance(context: Context): Connector {
			if (databaseClient == null) {
				databaseClient = createInstance(context)
			}
			return databaseClient!!
		}

		private fun createInstance(context: Context): Connector {
			return Room
				.databaseBuilder(context, Connector::class.java, DATABSE_NAME)
				.allowMainThreadQueries()
				.build()
		}
	}
}