package com.github.fajaragungpramana.android

import com.github.fajaragungpramana.resulthelper.ResultHelper
import com.github.fajaragungpramana.resulthelper.connection

class MainRepository {

    fun getPersonName(): ResultHelper<String> = connection {
        val name = "Fajar Agung Pramana"
        if (name.isNotEmpty())
            ResultHelper.OnSuccess(name)
        else
            ResultHelper.OnFailure()
    }

}