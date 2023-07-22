package com.example.themoviesapp

import android.app.Application
import com.example.themoviesapp.data.di.AppComponent
import com.example.themoviesapp.data.di.AppModule
import com.example.themoviesapp.data.di.DaggerAppComponent
import com.example.themoviesapp.data.di.Injector
import com.example.themoviesapp.data.di.MovieSubComponent
import com.example.themoviesapp.data.di.NetModule
import com.example.themoviesapp.data.di.RemoteDataSource
import dagger.internal.DaggerCollections

class App:Application(),Injector
{
    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent= DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
                .remoteDataSource(RemoteDataSource(BuildConfig.API_KEY)).build()
    }


    override fun createMovieSubComp(): MovieSubComponent {
           return appComponent.movieSubComponent().create()
    }
}