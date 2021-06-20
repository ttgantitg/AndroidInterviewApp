package com.ttgantitg.androidinterviewapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.data.entities.Libs
import io.reactivex.Single

@Dao
interface LibsDao {
    @Query("SELECT * FROM libs")
    fun getAll(): Single<List<Libs>>
}
