package com.patrickmota.core.interactors

import com.patrickmota.core.data.DocumentRepository
import com.patrickmota.core.domain.Document

class AddDocument(private val documentRepository: DocumentRepository) {
  suspend operator fun invoke(document: Document) = documentRepository.addDocument(document)
}
