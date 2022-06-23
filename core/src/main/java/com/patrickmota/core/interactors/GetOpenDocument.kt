package com.raywenderlich.android.majesticreader.interactors

import com.patrickmota.core.data.DocumentRepository


class GetOpenDocument(private val documentRepository: DocumentRepository) {
  operator fun invoke() = documentRepository.getOpenDocument()
}
