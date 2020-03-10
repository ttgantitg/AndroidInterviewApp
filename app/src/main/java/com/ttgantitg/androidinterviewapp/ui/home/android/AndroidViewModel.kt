package com.ttgantitg.androidinterviewapp.ui.home.android

import androidx.lifecycle.ViewModel
import com.ttgantitg.androidinterviewapp.database.dao.AndroidDao
import com.ttgantitg.androidinterviewapp.database.entities.Android
import io.reactivex.Single

class AndroidViewModel(private val dataSource: AndroidDao) : ViewModel() {
    fun getData(): Single<List<Android>> {
        return dataSource.getAll()
    }
}
