package com.patrickmota.cleanarchitecture.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.patrickmota.cleanarchitecture.framework.Interactors
import com.patrickmota.cleanarchitecture.framework.MajesticReaderApplication

open class MajesticViewModel(application: Application, protected val interactors: Interactors) :
    AndroidViewModel(application) {

  protected val application: MajesticReaderApplication = getApplication()

}
