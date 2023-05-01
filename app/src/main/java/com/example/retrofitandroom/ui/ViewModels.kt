package com.example.retrofitandroom.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cheezycode.notesample.models.UserRequest
import com.example.retrofitandroom.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.cheezycode.notesample.models.UserResponse
import com.example.retrofitandroom.util.NetworkResource
import kotlinx.coroutines.launch

@HiltViewModel
class ViewModels @Inject constructor(val userRepository: UserRepository): ViewModel(){

     val userLiveData: LiveData<NetworkResource<UserResponse>>
    get() = userRepository.userResponseLiveData

    fun registerUser(userRequest: UserRequest){
        viewModelScope.launch {
            userRepository.registerUsers(userRequest)
        }
    }


    fun loginUser(userRequest: UserRequest){
        viewModelScope.launch {
            userRepository.loginUsers(userRequest)
        }
    }
}