package com.ttgantitg.androidinterviewapp.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "kotlin")
data class Kotlin (
    @PrimaryKey @NonNull @ColumnInfo(name = "question") val question: String,
    @NonNull @ColumnInfo(name = "answer") val answer: String
)