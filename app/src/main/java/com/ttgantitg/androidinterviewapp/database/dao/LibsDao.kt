package com.ttgantitg.androidinterviewapp.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.database.entities.Libs
import io.reactivex.Single

@Dao
interface LibsDao {
    @Query("SELECT * FROM libs")
    fun getAll(): Single<List<Libs>>
}
