package com.example.mi_post

import android.app.Activity
import android.app.Application
import com.example.mi_post.di.components.DaggerAppComponent
import com.example.mi_post.di.modules.AppModule
import com.example.mi_post.di.modules.NetModule
import com.example.mi_post.utils.Constants
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Festus Kiambi on 2/21/19.
 */
class MiPostApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule(Constants.BASE_URL))
            .build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}