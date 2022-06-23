package com.patrickmota.core.data

import com.patrickmota.core.domain.Document

interface OpenDocumentDataSource {

    fun setOpenDocument(document: Document)

    fun getOpenDocument(): Document

}