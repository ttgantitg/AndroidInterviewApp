package com.ttgantitg.androidinterviewapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.data.entities.Java
import io.reactivex.Single

@Dao
interface JavaDao {
    @Query("SELECT * FROM java")
    fun getAll(): Single<List<Java>>
}
