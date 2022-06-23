package com.patrickmota.core.interactors

import com.patrickmota.core.data.BookmarkRepository
import com.patrickmota.core.domain.Bookmark
import com.patrickmota.core.domain.Document

class RemoveBookmark(private val bookmarkRepository: BookmarkRepository) {
    suspend operator fun invoke(document: Document, bookmark: Bookmark) =
        bookmarkRepository.removeBookmark(document, bookmark)
}