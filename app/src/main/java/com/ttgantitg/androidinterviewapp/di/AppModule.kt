package com.ttgantitg.androidinterviewapp.di

import android.content.Context
import androidx.room.Room
import com.ttgantitg.androidinterviewapp.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    private val mDBName = "interview.db"

    @Singleton
    @Provides
    fun providesAppContext() = context

    @Singleton
    @Provides fun providesAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, mDBName)
            .createFromAsset("databases/$mDBName")
            .build()

    @Singleton
    @Provides fun providesJavaDao(database: AppDatabase) = database.javaDao()
    @Singleton
    @Provides fun providesKotlinDao(database: AppDatabase) = database.kotlinDao()
    @Singleton
    @Provides fun providesAndroidDao(database: AppDatabase) = database.androidDao()
    @Singleton
    @Provides fun providesLibsDao(database: AppDatabase) = database.libsDao()
    @Singleton
    @Provides fun providesGeneralDao(database: AppDatabase) = database.generalDao()
}