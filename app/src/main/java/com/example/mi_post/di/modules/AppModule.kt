package com.example.mi_post.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Festus Kiambi on 2/21/19.
 */
@Module
class AppModule(val app: Application){

    @Provides
    @Singleton
    fun provideApplication(): Application = app
}