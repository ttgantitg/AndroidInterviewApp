package com.ttgantitg.androidinterviewapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.data.entities.Kotlin
import io.reactivex.Single

@Dao
interface KotlinDao {
    @Query("SELECT * FROM kotlin")
    fun getAll(): Single<List<Kotlin>>
}
