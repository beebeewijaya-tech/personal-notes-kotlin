package com.beebee.notes.view.custom_view.detail

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.navigation.findNavController
import com.beebee.notes.model.entities.notes.Notes
import com.beebee.notes.model.room.notes.RoomNotes
import kotlinx.android.synthetic.main.input_notes.view.*

class DetailContainer @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
	fun initView(note: Notes, notesModel: RoomNotes) {
		renderContent(note, notesModel)
	}

	private fun renderContent(note: Notes, notesModel: RoomNotes) {
		input_title.setText(note.title)
		input_body.setText(note.description)


		save_notes.setOnClickListener { saveNote(note, notesModel) }
	}

	private fun saveNote(note: Notes, notesModel: RoomNotes) {
		val title = input_title.text.toString()
		val body = input_body.text.toString()

		val notes = Notes(
			uuid = note.uuid,
			title = title,
			description = body
		)

		notesModel.addNotes(notes).apply {
			findNavController().popBackStack()
		}
	}
}
