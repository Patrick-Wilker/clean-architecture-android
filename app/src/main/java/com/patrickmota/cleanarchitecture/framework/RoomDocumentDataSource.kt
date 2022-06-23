package com.patrickmota.cleanarchitecture.framework

import android.content.Context
import com.patrickmota.cleanarchitecture.framework.db.DocumentEntity
import com.patrickmota.cleanarchitecture.framework.db.MajesticReaderDatabase
import com.patrickmota.core.data.DocumentDataSource
import com.patrickmota.core.domain.Document

class RoomDocumentDataSource(val context: Context) : DocumentDataSource {

    private val documentDao = MajesticReaderDatabase.getInstance(context).documentDao()

    override suspend fun add(document: Document) {
        val details = FileUtil.getDocumentDetails(context, document.url)
        documentDao.addDocument(
            DocumentEntity(document.url, details.name, details.size, details.thumbnail)
        )
    }

    override suspend fun readAll(): List<Document> = documentDao.getDocuments().map {
        Document(
            it.uri,
            it.title,
            it.size,
            it.thumbnailUri
        )
    }

    override suspend fun remove(document: Document) = documentDao.removeDocument(
        DocumentEntity(document.url, document.name, document.size, document.thumbnail)
    )
}