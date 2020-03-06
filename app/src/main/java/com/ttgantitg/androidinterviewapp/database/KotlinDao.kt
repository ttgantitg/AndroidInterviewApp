package com.ttgantitg.androidinterviewapp.database

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Single

@Dao
interface KotlinDao {
    @Query("SELECT * FROM kotlin")
    fun getAll(): Single<List<Kotlin>>
}
