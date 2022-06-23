package com.patrickmota.cleanarchitecture.presentation

import com.patrickmota.core.domain.Document

interface MainActivityDelegate {

  fun openDocument(document: com.patrickmota.core.domain.Document)
}