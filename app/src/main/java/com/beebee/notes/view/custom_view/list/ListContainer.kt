package com.beebee.notes.view.custom_view.list

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.beebee.notes.model.pojo.notes.Notes
import com.beebee.notes.view.ui.list.ListAdapter
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListContainer @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
	private lateinit var adapter: ListAdapter

	fun initView() {
		renderList()
	}

	private fun renderList() {
		list_notes.layoutManager = GridLayoutManager(context, 2)
		adapter = ListAdapter()
		list_notes.adapter = adapter
	}

	fun updateList(newList: List<Notes>) {
		adapter.updateList(newList)
	}
}