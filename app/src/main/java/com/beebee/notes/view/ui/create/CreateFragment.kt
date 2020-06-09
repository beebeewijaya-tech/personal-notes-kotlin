package com.beebee.notes.view.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.beebee.notes.R
import com.beebee.notes.model.room.notes.RoomNotes
import com.beebee.notes.util.base.BaseApplicationModule
import com.beebee.notes.view.custom_view.create.CreateContainer
import toothpick.Toothpick
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class CreateFragment : Fragment() {
	private lateinit var contentContainer: CreateContainer
	@Inject
	lateinit var notesModel: RoomNotes

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		Toothpick.inject(this, BaseApplicationModule.scope)
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_create, container, false).apply {
			contentContainer = this as CreateContainer
		}
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		renderContent()
	}

	private fun renderContent() {
		contentContainer.initView(notesModel)
	}
}
