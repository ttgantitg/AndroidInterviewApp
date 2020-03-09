package com.ttgantitg.androidinterviewapp.database

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.database.entities.Java
import com.ttgantitg.androidinterviewapp.database.entities.Kotlin
import io.reactivex.Single

@Dao
interface DataDao {
    @Query("SELECT * FROM java")
    fun getAllFromJava(): Single<List<Java>>

    @Query("SELECT * FROM kotlin")
    fun getAllFromKotlin(): Single<List<Kotlin>>
}
