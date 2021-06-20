package com.ttgantitg.androidinterviewapp.presentation.home.android

import androidx.lifecycle.ViewModel
import com.ttgantitg.androidinterviewapp.data.dao.AndroidDao
import com.ttgantitg.androidinterviewapp.data.entities.Android
import io.reactivex.Single
import javax.inject.Inject

class AndroidViewModel @Inject constructor(private val dataSource: AndroidDao) : ViewModel() {
    fun getData(): Single<List<Android>> {
        return dataSource.getAll()
    }
}
