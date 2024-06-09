package com.example.todoapi.social.oauth2.service

import com.example.todoapi.social.oauth2.client.Oauth2Client
import com.example.todoapi.users.repository.ISocialUserRepository
import com.example.todoapi.users.service.UsersService
import org.springframework.stereotype.Service

@Service
class Oauth2LoginService(
    private val oauth2Client: Oauth2Client,
    private val usersService: UsersService
    //private val iSocialUserRepository: ISocialUserRepository // 빈 등록 안되는지 확인 후 userInfo 제대로 들어오는지 테스트
) {
    fun oauthLogin(code: String, sessionState: Any): Map<*, *>? {
        // 1. code 로 provider 에 Access 토큰 요청 -> Oauth2Client 사용
        val tokenResponse  = oauth2Client.requestAccessToken(code, sessionState)
        // 2. Access 토큰으로 Resource Server 에 사용자정보 요청 -> Oauth2Client 사용
        val accessToken = tokenResponse?.get("access_token").toString()
        val userInfo = oauth2Client.requestUserInfo(accessToken)
        println(userInfo)
        // 3. 사용자정보로 todo 애플리케이션의 회원가입 or 로그인 처리 -> SocialUserService/Repository 사용
        if (userInfo != null) {
            println(userInfo.response.name)
        }
        // 4. Access 토큰 발행 -> JWT helper 사용
        // 5. Access 토큰 반환

        return tokenResponse
    }

}