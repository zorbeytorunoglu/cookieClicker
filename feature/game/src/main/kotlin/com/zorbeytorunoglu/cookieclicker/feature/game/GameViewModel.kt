package com.zorbeytorunoglu.cookieclicker.feature.game

import androidx.lifecycle.ViewModel
import com.zorbeytorunoglu.cookieclicker.data.repository.CookieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val cookieRepository: CookieRepository
): ViewModel() {

    val cookies = cookieRepository.cookies

    fun incrementCookies() = cookieRepository.incrementCookie()

}