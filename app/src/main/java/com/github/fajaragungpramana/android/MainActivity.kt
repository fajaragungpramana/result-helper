package com.github.fajaragungpramana.android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.fajaragungpramana.resulthelper.onResultListener

class MainActivity : AppCompatActivity() {

    private lateinit var mMainRepository: MainRepository

    private val mPersonName by lazy { findViewById<TextView>(R.id.tv_name) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!::mMainRepository.isInitialized) mMainRepository = MainRepository()

        mMainRepository.getPersonName().onResultListener(
            onSuccess = { data, code, message ->
                // TODO: Do something magic here when get result success.
                mPersonName.text = data
            },
            onFailure = { data, code, message ->
                // TODO: Do something magic here when get result failure.
            },
            onError = { throwable ->
                // TODO: Do something magic here when get result error.
            }
        )

    }

}