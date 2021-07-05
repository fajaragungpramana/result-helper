# Android Result Helper
[![](https://jitpack.io/v/fajaragungpramana/result-helper.svg)](https://jitpack.io/#fajaragungpramana/result-helper)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
</br>
</br>
Library for android. Helping you to handle data result from remote data source or local data source.

## Installation
Add it in your root build.gradle at the end of repositories:
```gradle
allProjects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency:
```gradle
dependencies {
	implementation 'com.github.fajaragungpramana:result-helper:0.0.2'
}
```

## Usage
First step. You can create function return `ResultHelper<TYPE>` to handle your data result. For example in my `MainRepository.kt`
```kotlin
class MainRepository {

    fun getPersonName(): ResultHelper<String> = connection {
        val name = "Fajar Agung Pramana"
        if (name.isNotEmpty())
            ResultHelper.OnSuccess(name)
        else
            ResultHelper.OnFailure()
    }

}
```
`connection {}` is wrapper function to handle result when your logic get an exception. you can handle the exception result in `ResultHelper.OnError(Throwable)`

And in your `Activity` or `Fragment` or `ViewModel` or another class. You can call the function like code bellow. For example `MainActivity.kt`
```kotlin
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
```

## Preview
<a href="url"><img src="https://github.com/fajaragungpramana/assets/blob/master/ResultHelper/ResultHelper.jpg" align="left" height="640" width="320" ></a>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>

## License
Copyright 2021 Fajar Agung Pramana

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
