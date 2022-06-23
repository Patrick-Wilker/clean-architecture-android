package com.patrickmota.cleanarchitecture.framework

import com.patrickmota.core.data.OpenDocumentDataSource
import com.patrickmota.core.domain.Document

class InMemoryOpenDocumentDataSource : OpenDocumentDataSource {

    private var openDocument: Document = Document.EMPTY

    override fun setOpenDocument(document: Document) {
        openDocument = document
    }

    override fun getOpenDocument() = openDocument
}