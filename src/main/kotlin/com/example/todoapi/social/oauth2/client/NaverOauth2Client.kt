package com.example.todoapi.social.oauth2.client

import com.example.todoapi.social.oauth2.dto.NaverUserInfoDto
import org.springframework.http.*
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate

@Component
class NaverOauth2Client : Oauth2Client{
    override fun requestAccessToken(code: String, sessionState : Any): Map<*, *>? {
        val tokenUrl = "https://nid.naver.com/oauth2.0/token"
        val restTemplate = RestTemplate()

        val NAVER_CLIENT_SECRET = "Pr66f1oAeJ"
        val NAVER_CLIENT_ID = "TLjpwgasybwAyOjCzRIM"
        //val CLIENT_SECRET = System.getenv("NAVER_CLIENT_SECRET")
        val headers = HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED)

        val body: MultiValueMap<String, String> = LinkedMultiValueMap()
        body.add("grant_type", "authorization_code")
        body.add("client_id", NAVER_CLIENT_ID)
        body.add("client_secret", NAVER_CLIENT_SECRET)

        body.add("code", code)
        body.add("state", sessionState.toString())

        val entity = HttpEntity(body, headers)

        val response = restTemplate.exchange(
            tokenUrl, HttpMethod.POST, entity,
            Map::class.java
        )

        return response.body
    }

    override fun requestUserInfo(accessToken: String): NaverUserInfoDto? {
        val userInfoRequestUrl = "https://openapi.naver.com/v1/nid/me"
        val authorizationToken = "Bearer $accessToken"
        val headers = HttpHeaders()
//            .apply {
//            set("Authorization", authorizationToken)
//        }
        headers.add("Authorization", authorizationToken)
        val restTemplate = RestTemplate()
        val entity = HttpEntity<String>(headers)

        val response = restTemplate.exchange(
            userInfoRequestUrl, HttpMethod.GET, entity,
            NaverUserInfoDto::class.java
        )
        return response.body
    }

}