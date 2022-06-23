package com.raywenderlich.android.majesticreader.interactors

import com.patrickmota.core.data.DocumentRepository
import com.patrickmota.core.domain.Document


class SetOpenDocument(private val documentRepository: DocumentRepository) {
  operator fun invoke(document: Document) = documentRepository.setOpenDocument(document)
}