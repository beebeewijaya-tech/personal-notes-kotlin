package com.beebee.notes.util.base

import android.app.Application

class Application: Application() {
	companion object {
		lateinit var instance: com.beebee.notes.util.base.Application
	}

	init {
		instance = this
	}
}