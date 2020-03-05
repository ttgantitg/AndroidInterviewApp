package com.ttgantitg.androidinterviewapp.ui.kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ttgantitg.androidinterviewapp.database.AppDatabase
import com.ttgantitg.androidinterviewapp.database.Kotlin
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.function.Consumer

class KotlinViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext

    fun getData() {

    }

//    fun getAllData() {
//        GlobalScope.launch {
//            val data = AppDatabase.getAppDataBase(context)?.kotlinDao()?.getAll()
//            data?.forEach {
//                println(it)
//            }
//        }
//    }
}
