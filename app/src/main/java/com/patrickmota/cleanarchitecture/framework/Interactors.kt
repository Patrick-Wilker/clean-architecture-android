package com.patrickmota.cleanarchitecture.framework

import com.patrickmota.core.interactors.AddBookmark
import com.patrickmota.core.interactors.AddDocument
import com.patrickmota.core.interactors.GetBookmarks
import com.patrickmota.core.interactors.RemoveBookmark
import com.raywenderlich.android.majesticreader.interactors.GetDocuments
import com.raywenderlich.android.majesticreader.interactors.GetOpenDocument
import com.raywenderlich.android.majesticreader.interactors.RemoveDocument
import com.raywenderlich.android.majesticreader.interactors.SetOpenDocument

data class Interactors(
    val addBookmark: AddBookmark,
    val getBookmarks: GetBookmarks,
    val deleteBookmark: RemoveBookmark,
    val addDocument: AddDocument,
    val getDocuments: GetDocuments,
    val removeDocument: RemoveDocument,
    val getOpenDocument: GetOpenDocument,
    val setOpenDocument: SetOpenDocument
)