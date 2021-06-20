package com.ttgantitg.androidinterviewapp.di

import android.app.Application
import android.content.Context
import com.ttgantitg.androidinterviewapp.InterviewApplication
import com.ttgantitg.androidinterviewapp.di.modules.ApplicationModule
import com.ttgantitg.androidinterviewapp.di.modules.DatabaseModule
import com.ttgantitg.androidinterviewapp.di.modules.ViewModelModule
import com.ttgantitg.androidinterviewapp.di.qualifiers.ApplicationContext
import com.ttgantitg.androidinterviewapp.di.qualifiers.DatabaseInfo
import com.ttgantitg.androidinterviewapp.presentation.home.android.AndroidFragment
import com.ttgantitg.androidinterviewapp.presentation.home.general.GeneralFragment
import com.ttgantitg.androidinterviewapp.presentation.home.java.JavaFragment
import com.ttgantitg.androidinterviewapp.presentation.home.kotlin.KotlinFragment
import com.ttgantitg.androidinterviewapp.presentation.home.libs.LibsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DatabaseModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(interviewApplication: InterviewApplication?)
    fun inject(javaFragment: JavaFragment?)
    fun inject(kotlinFragment: KotlinFragment?)
    fun inject(androidFragment: AndroidFragment?)
    fun inject(libsFragment: LibsFragment?)
    fun inject(generalFragment: GeneralFragment?)

    @get:ApplicationContext
    val context: Context?
    val application: Application?

    @get:DatabaseInfo
    val databaseName: String?
}