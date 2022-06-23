package com.patrickmota.cleanarchitecture.framework

import android.app.Application
import com.patrickmota.core.data.BookmarkRepository
import com.patrickmota.core.data.DocumentRepository
import com.patrickmota.core.interactors.AddBookmark
import com.patrickmota.core.interactors.AddDocument
import com.patrickmota.core.interactors.GetBookmarks
import com.patrickmota.core.interactors.RemoveBookmark
import com.raywenderlich.android.majesticreader.interactors.GetDocuments
import com.raywenderlich.android.majesticreader.interactors.GetOpenDocument
import com.raywenderlich.android.majesticreader.interactors.RemoveDocument
import com.raywenderlich.android.majesticreader.interactors.SetOpenDocument

class MajesticReaderApplication : Application() {

  override fun onCreate() {
    super.onCreate()

      val bookmarkRepository = BookmarkRepository(RoomBookmarkDataSource(this))
      val documentRepository = DocumentRepository(
          RoomDocumentDataSource(this),
          InMemoryOpenDocumentDataSource()
      )

      MajesticViewModelFactory.inject(
          this,
          Interactors(
              AddBookmark(bookmarkRepository),
              GetBookmarks(bookmarkRepository),
              RemoveBookmark(bookmarkRepository),
              AddDocument(documentRepository),
              GetDocuments(documentRepository),
              RemoveDocument(documentRepository),
              GetOpenDocument(documentRepository),
              SetOpenDocument(documentRepository)
          )
      )
  }
}