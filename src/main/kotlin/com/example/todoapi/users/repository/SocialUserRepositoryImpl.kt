package com.example.todoapi.users.repository

class SocialUserRepositoryImpl(
    private val naverSocialUsersRepository: NaverSocialUsersRepository
) : ISocialUserRepository{
    override fun isExistUserById(socialId: String): Boolean {
        // provider 가 변경되는 구조로 리팩터링 시 구현부 수정 필수!
        return naverSocialUsersRepository.existsById(socialId)
    }
}