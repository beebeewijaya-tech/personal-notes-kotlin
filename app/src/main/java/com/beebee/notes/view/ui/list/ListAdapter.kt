package com.beebee.notes.view.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beebee.notes.R
import com.beebee.notes.model.pojo.notes.Notes
import kotlinx.android.synthetic.main.item_note.view.*

class ListAdapter(
		val notesList: MutableList<Notes>
): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
	class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
		fun bind(note: Notes) {
			view.title.text = note.title
			view.description.text = note.description
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
			LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
	)

	override fun getItemCount(): Int = notesList.size

	override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
		holder.bind(notesList[position])
	}
}