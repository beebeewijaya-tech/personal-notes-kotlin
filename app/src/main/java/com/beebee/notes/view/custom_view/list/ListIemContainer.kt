package com.beebee.notes.view.custom_view.list

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.beebee.notes.model.pojo.notes.Notes
import com.beebee.notes.view.ui.list.ListFragmentDirections
import kotlinx.android.synthetic.main.item_note.view.*

class ListIemContainer @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {
	fun initView(note: Notes) {
		title.text = note.title
		description.text = note.description


		this.setOnClickListener {
			val action = ListFragmentDirections.actionListFragmentToDetailFragment(note)
			findNavController().navigate(action)
		}
	}
}