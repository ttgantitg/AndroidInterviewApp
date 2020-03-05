package com.ttgantitg.androidinterviewapp.ui.kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ttgantitg.androidinterviewapp.database.AppDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class KotlinViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application.applicationContext

    fun getData() {
        AppDatabase.getAppDataBase(context)?.kotlinDao()?.getAll()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe {
                println(it)
            }
    }
}
