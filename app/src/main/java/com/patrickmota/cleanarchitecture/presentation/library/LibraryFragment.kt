package com.patrickmota.cleanarchitecture.presentation.library

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.patrickmota.cleanarchitecture.R
import com.patrickmota.cleanarchitecture.framework.Interactors
import com.patrickmota.cleanarchitecture.framework.MajesticViewModelFactory
import com.patrickmota.cleanarchitecture.framework.MajesticViewModelFactory.application
import com.patrickmota.cleanarchitecture.presentation.IntentUtil.createOpenIntent
import com.patrickmota.cleanarchitecture.presentation.MainActivityDelegate
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment : Fragment() {

  companion object {
    const val READ_REQUEST_CODE = 100

    fun newInstance() = LibraryFragment()
  }

  private lateinit var viewModel: LibraryViewModel

  private lateinit var mainActivityDelegate: MainActivityDelegate

  override fun onAttach(context: Context) {
    super.onAttach(context)

    try {
      mainActivityDelegate = context as MainActivityDelegate
    } catch (e: ClassCastException) {
      throw ClassCastException()
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_library, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    val adapter = DocumentsAdapter(glide = Glide.with(this)) {
      mainActivityDelegate.openDocument(it)
    }
    documentsRecyclerView.adapter = adapter

    viewModel = ViewModelProvider(this, MajesticViewModelFactory)[LibraryViewModel::class.java]
    viewModel.documents.observe(viewLifecycleOwner, Observer { adapter.update(it) })
    viewModel.loadDocuments()

    fab.setOnClickListener { startActivityForResult(createOpenIntent(), READ_REQUEST_CODE) }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    // Process open file intent.
    if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
      data?.data?.also { uri -> viewModel.addDocument(uri) }
    } else {
      super.onActivityResult(requestCode, resultCode, data)
    }
  }

}
