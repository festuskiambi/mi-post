package com.example.mi_post.di.components

import android.app.Application
import com.example.mi_post.di.modules.AppModule
import com.example.mi_post.di.modules.BuildersModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Festus Kiambi on 2/21/19.
 */

@Singleton
@Component(
    modules = arrayOf(AndroidInjectionModule::class, BuildersModule::class, AppModule::class)
)
interface AppComponent {
    fun inject(app: Application)
}