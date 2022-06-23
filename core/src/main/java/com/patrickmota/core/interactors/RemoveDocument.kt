package com.raywenderlich.android.majesticreader.interactors

import com.patrickmota.core.data.DocumentRepository
import com.patrickmota.core.domain.Document


class RemoveDocument(private val documentRepository: DocumentRepository) {
  suspend operator fun invoke(document: Document) = documentRepository.removeDocument(document)
}