package com.zorbeytorunoglu.cookieclicker.data.repository

import kotlinx.coroutines.flow.Flow

interface CookieRepository {

    val cookies: Flow<Int>

    fun incrementCookie()

}