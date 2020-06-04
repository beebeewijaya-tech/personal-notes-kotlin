package com.beebee.notes.view.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.beebee.notes.R
import com.beebee.notes.model.pojo.notes.Notes
import com.beebee.notes.view.custom_view.list.ListIemContainer
import kotlinx.android.synthetic.main.item_note.view.*

class ListAdapter(
		val notesList: MutableList<Notes> = mutableListOf()
): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
	class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
		fun bind(note: Notes) {
			(view as ListIemContainer).initView(note)
		}
	}

	fun updateList(newList: List<Notes>) {
		val diffUtil = ListDiffUtil(notesList, newList)
		val diffResult = DiffUtil.calculateDiff(diffUtil)
		notesList.clear()
		notesList.addAll(newList)
		diffResult.dispatchUpdatesTo(this)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
			LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
	)

	override fun getItemCount(): Int = notesList.size

	override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
		holder.bind(notesList[position])
	}

	class ListDiffUtil(val oldList: MutableList<Notes>, val newList: List<Notes>): DiffUtil.Callback() {
		override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
			oldList[oldItemPosition] === newList[newItemPosition]

		override fun getOldListSize(): Int = oldList.size

		override fun getNewListSize(): Int = newList.size

		override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
			oldList[oldItemPosition].title === newList[newItemPosition].title
	}
}