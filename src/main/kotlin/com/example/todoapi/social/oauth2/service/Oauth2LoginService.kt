package com.example.todoapi.social.oauth2.service

import com.example.todoapi.security.jwt.JwtUtil
import com.example.todoapi.social.oauth2.client.Oauth2Client
import com.example.todoapi.social.oauth2.dto.NaverUserInfoDto
import com.example.todoapi.users.repository.ISocialUserRepository
import com.example.todoapi.users.repository.NaverSocialUsersRepository
import com.example.todoapi.users.service.UsersService
import org.springframework.stereotype.Service

@Service
class Oauth2LoginService(
    private val oauth2Client: Oauth2Client,
    private val usersService: UsersService,
    private val naverSocialUsersRepository: NaverSocialUsersRepository,
    private val jwtUtil: JwtUtil
) {
    fun oauthLogin(code: String, sessionState: Any): String {
        // 1. code 로 provider 에 Access 토큰 요청 -> Oauth2Client 사용
        val tokenResponse  = oauth2Client.requestAccessToken(code, sessionState)
        // 2. Access 토큰으로 Resource Server 에 사용자정보 요청 -> Oauth2Client 사용
        val accessToken = tokenResponse?.get("access_token").toString()
        val userInfo: NaverUserInfoDto = oauth2Client.requestUserInfo(accessToken)!!
        //println(userInfo)
        // 3. 사용자정보로 todo 애플리케이션의 회원가입 or 로그인 처리 -> SocialUserService/Repository 사용
        //println(userInfo.response.name)
        println(naverSocialUsersRepository.existsById(userInfo.response.id))
        if(!naverSocialUsersRepository.existsById(userInfo.response.id)){
            // 회원가입
            usersService.signin(userInfo.response)
        }
        // 4. Access 토큰 발행 -> JWT Util 사용, 토큰 반환
        val userId = naverSocialUsersRepository.findById(userInfo.response.id).orElseThrow().users.id!!
        userId.let { return jwtUtil.generateAccessToken(it) }
    }

}
