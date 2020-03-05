package com.ttgantitg.androidinterviewapp.database

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface KotlinDao {
    @Query("SELECT * FROM kotlin")
    fun getAll(): Flowable<List<Kotlin>>
}
