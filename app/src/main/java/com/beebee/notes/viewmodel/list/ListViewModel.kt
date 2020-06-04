package com.beebee.notes.viewmodel.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.beebee.notes.model.pojo.notes.Notes
import com.beebee.notes.model.room.notes.RoomNotes
import com.beebee.notes.util.base.BaseApplicationModule
import toothpick.Toothpick
import javax.inject.Inject

class ListViewModel: ViewModel() {
	@Inject
	lateinit var model: RoomNotes

	private var _notesLiveData: MutableLiveData<List<Notes>> = MutableLiveData()
	val notesLiveData = _notesLiveData

	init {
		Toothpick.inject(this, BaseApplicationModule.scope)
		this._notesLiveData.postValue(model.getFakeNotes())
	}
}