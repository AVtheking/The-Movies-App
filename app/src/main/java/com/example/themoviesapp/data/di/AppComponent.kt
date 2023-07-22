package com.example.themoviesapp.data.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
              CacheDataModule::class,
              DatabaseModule::class,
              LocalDataModule::class,

    NetModule::class,
    RemoteDataSource::class,
    RepositoryModule::class,
    UseCaseModule::class
    
    ]
)
interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
}