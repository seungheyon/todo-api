package com.example.todoapi.social.oauth2.client

import com.example.todoapi.social.oauth2.dto.NaverUserInfoDto


interface Oauth2Client {
    fun requestAccessToken(code: String, sessionState: Any): Map<*, *>?
    fun requestUserInfo(accessToken: String): NaverUserInfoDto?
}