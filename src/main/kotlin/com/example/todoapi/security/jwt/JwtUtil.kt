package com.example.todoapi.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.time.Instant
import java.util.*

@Component
class JwtUtil(
    @org.springframework.beans.factory.annotation.Value("\$(auth.jwt.issuer)")
    private val issuer: String,
    @org.springframework.beans.factory.annotation.Value("\$(auth.jwt.secret)")
    private val secrett: String,
    @org.springframework.beans.factory.annotation.Value("\$(auth.jwt.jwtTokenExpirationHour)")
    private val jwtTokenExpirationHour: String
) {

    private val secret = "WYHOtSNvaWD8Zkm9wfVGrj+jzS6VHo3fALye8VOP6ivEIXcvoL4s9yRMG5dzyDTUqRS7v2ioLcVnbcox/2upqQ=="
    fun generateAccessToken(subject: Long): String{

//        val claims = Jwts.claims()
//            .add(mapOf("userId" to userId))
//            .build()
        val key = Keys.hmacShaKeyFor(secret.toByteArray(StandardCharsets.UTF_8))
        val now = Instant.now()

        val expirationTime = Duration.ofHours(24)

        return Jwts.builder()
            .subject(subject.toString())
            .issuer(issuer)
            .issuedAt(Date.from(now))
            .expiration(Date.from(now.plus(expirationTime)))
            .signWith(key)
            .compact()
    }



    fun validateToken(jwt: String): Result<Jws<Claims>> {
        return kotlin.runCatching {
            val key = Keys.hmacShaKeyFor(secret.toByteArray(StandardCharsets.UTF_8))
            Jwts.parser().verifyWith(key).build().parseSignedClaims(jwt)
        }
    }

}