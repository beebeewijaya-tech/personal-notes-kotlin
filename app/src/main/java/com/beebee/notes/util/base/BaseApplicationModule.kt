package com.beebee.notes.util.base

import com.beebee.notes.model.room.notes.RoomNotes
import com.beebee.notes.viewmodel.list.ListViewModel
import toothpick.Toothpick
import toothpick.config.Module
import toothpick.ktp.binding.bind

object BaseApplicationModule {
	val scope = Toothpick.openScope(this).apply {
		installModules(ApplicationModule)
	}
}

object ApplicationModule: Module() {
	init {
		bind(ListViewModel::class.java) to RoomNotes()
	}
}