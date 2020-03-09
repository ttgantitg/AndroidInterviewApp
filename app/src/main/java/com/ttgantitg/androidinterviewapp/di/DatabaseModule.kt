package com.ttgantitg.androidinterviewapp.di

import android.content.Context
import androidx.room.Room
import com.ttgantitg.androidinterviewapp.database.AppDatabase
import com.ttgantitg.androidinterviewapp.database.dao.JavaDao
import com.ttgantitg.androidinterviewapp.database.dao.KotlinDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule(@ApplicationContext context: Context) {

    @ApplicationContext
    private val mContext: Context = context

    @DatabaseInfo
    private val mDBName = "interview.db"

    @Singleton
    @Provides
    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(
            mContext,
            AppDatabase::class.java,
            mDBName
        ).fallbackToDestructiveMigration()
         .createFromAsset("databases/$mDBName")
         .build()
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return mDBName
    }

    @Singleton
    @Provides
    fun provideJavaDao(db: AppDatabase): JavaDao {
        return db.javaDao()
    }

    @Singleton
    @Provides
    fun provideKotlinDao(db: AppDatabase): KotlinDao {
        return db.kotlinDao()
    }
}