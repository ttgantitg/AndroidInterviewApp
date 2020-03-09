package com.ttgantitg.androidinterviewapp.di

import android.app.Application
import android.content.Context
import com.ttgantitg.androidinterviewapp.InterviewApplication
import com.ttgantitg.androidinterviewapp.ui.home.java.JavaFragment
import com.ttgantitg.androidinterviewapp.ui.home.kotlin.KotlinFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DatabaseModule::class])
interface ApplicationComponent {
    fun inject(interviewApplication: InterviewApplication?)
    fun inject(javaFragment: JavaFragment?)
    fun inject(kotlinFragment: KotlinFragment?)

    @get:ApplicationContext
    val context: Context?
    val application: Application?

    @get:DatabaseInfo
    val databaseName: String?
}