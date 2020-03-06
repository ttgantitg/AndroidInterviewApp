package com.ttgantitg.androidinterviewapp.ui.kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ttgantitg.androidinterviewapp.database.AppDatabase
import com.ttgantitg.androidinterviewapp.database.Kotlin
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class KotlinViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application.applicationContext
    var kotlinData = MutableLiveData<List<Kotlin>>()

    fun getData() {
        AppDatabase.getAppDataBase(context)?.kotlinDao()?.getAll()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : SingleObserver<List<Kotlin>> {
                override fun onSuccess(t: List<Kotlin>) {
                    kotlinData.value = t
                }
                override fun onSubscribe(d: Disposable) {}
                override fun onError(e: Throwable) {}
            })
    }
}
