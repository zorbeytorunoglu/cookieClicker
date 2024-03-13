package com.zorbeytorunoglu.cookieclicker.data.di

import com.zorbeytorunoglu.cookieclicker.data.datasource.CookieDataSource
import com.zorbeytorunoglu.cookieclicker.data.repository.CookieRepository
import com.zorbeytorunoglu.cookieclicker.data.repository.impl.CookieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsCookieRepository(
        cookieRepositoryImpl: CookieRepositoryImpl
    ): CookieRepository

}