package com.example.todoapi.social.oauth2.controller

import com.example.todoapi.social.oauth2.dto.LoginResponseDto
import com.example.todoapi.social.oauth2.service.Oauth2LoginService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.*
import org.springframework.ui.Model
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.servlet.view.RedirectView
import java.math.BigInteger
import java.security.SecureRandom


@RestController
@RequestMapping("/oauth2")
class Oauth2LoginController(
    private val oauth2LoginService: Oauth2LoginService
) {

    val NAVER_CLIENT_ID = "TLjpwgasybwAyOjCzRIM"

    @GetMapping("/naver/login")
    fun naverLogin(request : HttpServletRequest, model : Model) : RedirectView {
        val state = generateState()
        request.session.setAttribute("state", state)
        val REDIRECT_URI = "http://localhost:8080/oauth2/callback"
        val naverAuthUrl = "https://nid.naver.com/oauth2.0/authorize?client_id=" + NAVER_CLIENT_ID + "&response_type=code" + "&redirect_uri=" + REDIRECT_URI + "&state=" + state;
        return RedirectView(naverAuthUrl)
    }

    @GetMapping("/callback")
    fun callBack(
        @RequestParam("code") code : String,
        @RequestParam("state") state : String,
        request: HttpServletRequest, model: Model
    ): ResponseEntity<LoginResponseDto> {
        //Session 의 state 정보와 Redirect 요청의 state 정보가 일치하는지 확인
        val session = request.session
        val sessionState = session.getAttribute("state")

        if (sessionState == null || !sessionState.equals(state)) {
            throw IllegalStateException("Invalid state token");
        }
        //Login Service 호출
        return ResponseEntity.status(HttpStatus.OK)
            .body(LoginResponseDto(oauth2LoginService.oauthLogin(code, sessionState)))
    }

    @GetMapping("/naver/callback")
    fun naverCallback(
        @RequestParam("code") code : String,
        @RequestParam("state") state : String,
        request: HttpServletRequest, model: Model
    ): String {

        val session = request.session
        val sessionState = session.getAttribute("state")

        if (sessionState == null || !sessionState.equals(state)) {
            throw IllegalStateException("Invalid state token");
        }

        val accessToken = getAccessToken(code, sessionState)

        return accessToken
    }


    fun generateState() : String {
        val radomState = SecureRandom()
        return BigInteger(130, radomState).toString(32)
    }

    private fun getAccessToken(code: String, sessionState: Any): String {
        val tokenUrl = "https://nid.naver.com/oauth2.0/token"
        val restTemplate = RestTemplate()

        val NAVER_CLIENT_SECRET = "Pr66f1oAeJ"
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
            String::class.java
        )

        return response.body!!
    }
}