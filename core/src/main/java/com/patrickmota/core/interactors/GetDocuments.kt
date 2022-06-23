package com.raywenderlich.android.majesticreader.interactors

import com.patrickmota.core.data.DocumentRepository


class GetDocuments(private val documentRepository: DocumentRepository) {
  suspend operator fun invoke() = documentRepository.getDocuments()
}
