package com.ttgantitg.androidinterviewapp.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "java")
data class Java (
    @PrimaryKey @NonNull @ColumnInfo(name = "question") val question: String,
    @NonNull @ColumnInfo(name = "answer") val answer: String
)