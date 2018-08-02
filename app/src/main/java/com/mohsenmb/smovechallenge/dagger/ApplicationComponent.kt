package com.mohsenmb.smovechallenge.dagger

import com.mohsenmb.smovechallenge.SmoveApplication
import com.mohsenmb.smovechallenge.data.ApiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApiModule::class,
    ContributorsModule::class
])
interface ApplicationComponent : AndroidInjector<SmoveApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: SmoveApplication): Builder

        fun build(): ApplicationComponent
    }

}