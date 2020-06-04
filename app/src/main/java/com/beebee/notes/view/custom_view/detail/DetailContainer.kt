package com.beebee.notes.view.custom_view.detail

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.beebee.notes.model.pojo.notes.Notes
import kotlinx.android.synthetic.main.input_notes.view.*

class DetailContainer @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
	fun initView(note: Notes) {
		renderContent(note)
	}

	private fun renderContent(note: Notes) {
		input_title.setText(note.title)
		input_body.setText(note.description)
	}
}
