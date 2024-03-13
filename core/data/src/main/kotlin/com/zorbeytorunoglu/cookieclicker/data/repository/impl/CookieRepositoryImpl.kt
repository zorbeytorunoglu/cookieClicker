package com.zorbeytorunoglu.cookieclicker.data.repository.impl

import com.zorbeytorunoglu.cookieclicker.data.datasource.CookieDataSource
import com.zorbeytorunoglu.cookieclicker.data.repository.CookieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CookieRepositoryImpl @Inject constructor(
    private val dataSource: CookieDataSource
): CookieRepository {

    override val cookies: Flow<Int> = dataSource.cookies

    override fun incrementCookie() = dataSource.incrementCookie()

}