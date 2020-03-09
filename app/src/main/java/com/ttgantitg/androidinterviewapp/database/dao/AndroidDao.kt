package com.ttgantitg.androidinterviewapp.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.database.entities.Android
import io.reactivex.Single

@Dao
interface AndroidDao {
    @Query("SELECT * FROM android")
    fun getAll(): Single<List<Android>>
}
