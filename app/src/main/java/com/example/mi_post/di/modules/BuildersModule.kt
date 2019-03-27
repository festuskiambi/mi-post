package com.example.mi_post.di.modules

import com.example.mi_post.ui.post.postlist.PostListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Festus Kiambi on 2/21/19.
 */
@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun contibutePostListActivity(): PostListActivity
}