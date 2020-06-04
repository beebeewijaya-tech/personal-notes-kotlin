package com.beebee.notes.view.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.beebee.notes.R
import com.beebee.notes.view.custom_view.list.ListContainer
import com.beebee.notes.viewmodel.list.ListViewModel

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {
	private lateinit var contentView: ListContainer
	private val viewModel: ListViewModel
		get() = ViewModelProvider(this).get(ListViewModel::class.java)

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_list, container, false).apply {
			contentView = this as ListContainer
		}
	}


	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		renderContent()
		observeViewModel()
	}

	private fun renderContent() {
		contentView.initView()
	}

	private fun observeViewModel() {
		viewModel.notesLiveData.observe(viewLifecycleOwner, Observer {
			contentView.updateList(it)
		})
	}
}
