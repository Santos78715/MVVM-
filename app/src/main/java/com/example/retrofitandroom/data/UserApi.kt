package com.example.retrofitandroom.data

import com.cheezycode.notesample.models.UserRequest
import com.cheezycode.notesample.models.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

   @POST("/users/signup")
   suspend fun registerUser(@Body userRequest: UserRequest) : Response<UserResponse>


   @POST(" /users/signin")
   suspend fun signInUSer(@Body userRequest: UserRequest): Response<UserResponse>
}