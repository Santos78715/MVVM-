package com.example.retrofitandroom.domain

import com.cheezycode.notesample.models.UserRequest
import com.example.retrofitandroom.data.UserApi
import javax.inject.Inject

class UserRepository @Inject constructor(val userApi: UserApi) {

    suspend fun registerUsers(userRequest: UserRequest) {
        userApi.registerUser(userRequest)
    }

    suspend fun loginUsers(userRequest: UserRequest){
        userApi.signInUSer(userRequest)
    }
}