package com.patrickmota.core.data

import com.patrickmota.core.domain.Bookmark
import com.patrickmota.core.domain.Document

interface BookmarkDataSource {

    suspend fun add(document: Document, bookmark: Bookmark)

    suspend fun read(document: Document): List<Bookmark>

    suspend fun remove(document: Document, bookmark: Bookmark)
}
