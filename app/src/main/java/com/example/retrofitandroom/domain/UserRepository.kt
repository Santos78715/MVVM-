package com.example.retrofitandroom.domain

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cheezycode.notesample.models.UserRequest
import com.cheezycode.notesample.models.UserResponse
import com.example.retrofitandroom.data.UserApi
import com.example.retrofitandroom.util.Constants.MY_TAG
import com.example.retrofitandroom.util.NetworkResource
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor (private var userApi: UserApi) {

    private var _userResponseLiveData = MutableLiveData<NetworkResource<UserResponse>>()
    public val userReponseliveData: LiveData<NetworkResource<UserResponse>>
    get() = _userResponseLiveData
    suspend fun registerUser(userRequest: UserRequest){
      var response =   userApi.registerUser(userRequest)
        handleResponse(response)
    }

    suspend fun signinUser(userRequest: UserRequest){
       var response =  userApi.signInUSer(userRequest)
        handleResponse(response)
    }

    private fun handleResponse(response: Response<UserResponse>){
        if(response.isSuccessful){
            _userResponseLiveData.postValue(NetworkResource.Success(response.body()!!))
        }
        else if(response.errorBody()!= null){
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            _userResponseLiveData.postValue(NetworkResource.Error(errorObj.getString("message")))
        }else{
            _userResponseLiveData.postValue(NetworkResource.Error("Something Went Wrong"))
        }
    }
}

