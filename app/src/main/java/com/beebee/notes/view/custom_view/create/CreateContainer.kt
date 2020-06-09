package com.beebee.notes.view.custom_view.create

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.beebee.notes.model.entities.notes.Notes
import com.beebee.notes.model.room.notes.RoomNotes
import kotlinx.android.synthetic.main.input_notes.*
import kotlinx.android.synthetic.main.input_notes.view.*

class CreateContainer @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
	fun initView(notesModel: RoomNotes) {
		save_notes.setOnClickListener { saveNotes(notesModel) }
	}

	private fun saveNotes(notesModel: RoomNotes) {
		val title = input_title.text.toString()
		val body = input_body.text.toString()

		val notes = Notes(
			title = title,
			description = body
		)

		notesModel.addNotes(notes).apply {
			findNavController().popBackStack()
		}
	}
}