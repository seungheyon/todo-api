package com.example.todoapi.social.oauth2.dto

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor

@Getter
@AllArgsConstructor
@NoArgsConstructor
data class NaverUserInfoDto(
    val resultcode: String,
    val message: String,
    val response: NaverUserInfoBodyDto // 프로퍼티 이름이 naver 에서 내려 주는 필드 이름과 일치해야 함
)
