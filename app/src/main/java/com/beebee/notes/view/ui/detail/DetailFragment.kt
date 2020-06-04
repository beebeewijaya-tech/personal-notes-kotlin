package com.beebee.notes.view.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.beebee.notes.R
import com.beebee.notes.model.pojo.notes.Notes
import com.beebee.notes.view.custom_view.detail.DetailContainer

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
	private val args: DetailFragmentArgs by navArgs()
	private lateinit var contentView: DetailContainer

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_detail, container, false).apply {
			contentView = this as DetailContainer
		}
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		renderContent(args.note)
	}

	private fun renderContent(note: Notes) {
		contentView.initView(note)
	}
}
