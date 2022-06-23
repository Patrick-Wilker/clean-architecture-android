package com.patrickmota.cleanarchitecture.presentation.library

import android.app.Application
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import com.patrickmota.core.domain.Document
import com.patrickmota.cleanarchitecture.framework.Interactors
import com.patrickmota.cleanarchitecture.framework.MajesticViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LibraryViewModel(application: Application, interactors: Interactors)
  : MajesticViewModel(application, interactors) {

  val documents: MutableLiveData<List<com.patrickmota.core.domain.Document>> = MutableLiveData()

  fun loadDocuments() {
    GlobalScope.launch {
      documents.postValue(interactors.getDocuments())
    }
  }

  fun addDocument(uri: Uri) {
    GlobalScope.launch {
      withContext(Dispatchers.IO) {
        interactors.addDocument(Document(uri.toString(), "", 0, ""))
      }
      loadDocuments()
    }
  }

  fun setOpenDocument(document: Document) {
    interactors.setOpenDocument(document)
  }
}
