package com.example.retrofitandroom.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cheezycode.notesample.models.UserRequest
import com.cheezycode.notesample.models.UserResponse
import com.example.retrofitandroom.data.UserApi
import com.example.retrofitandroom.util.NetworkResource
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(val userApi: UserApi) {

    private val _userResponseLiveData = MutableLiveData<NetworkResource<UserResponse>>()
    val userResponseLiveData: LiveData<NetworkResource<UserResponse>>
    get()= _userResponseLiveData

    suspend fun registerUsers(userRequest: UserRequest) {
        val response = userApi.registerUser(userRequest)
        handleResponse(response)
    }

    suspend fun loginUsers(userRequest: UserRequest){
        val response = userApi.signInUSer(userRequest)
        handleResponse(response)
    }

    private fun handleResponse(response: Response<UserResponse>){
        if(response.isSuccessful && response.body() != null){
            _userResponseLiveData.postValue(NetworkResource.Success(response.body()!!))
        }
        else if (response.errorBody()!=null){
            val error_obj = JSONObject(response.errorBody()!!.charStream().readText())
            _userResponseLiveData.postValue(NetworkResource.Error(error_obj.getString("message")))
        }
        else{
            _userResponseLiveData.postValue(NetworkResource.Error("Something went wrong"))
        }
    }
}