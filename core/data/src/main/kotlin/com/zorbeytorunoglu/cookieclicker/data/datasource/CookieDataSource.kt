package com.zorbeytorunoglu.cookieclicker.data.datasource

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import javax.inject.Inject

class CookieDataSource @Inject constructor() {

    val cookies = MutableStateFlow(0)

    fun incrementCookie() {
        cookies.getAndUpdate { it+1 }
    }

}