package com.patrickmota.core.data

import com.patrickmota.core.domain.Document

interface DocumentDataSource {
    suspend fun add(document: Document)

    suspend fun readAll(): List<Document>

    suspend fun remove(document: Document)
}