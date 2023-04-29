package com.example.retrofitandroom.ui

import androidx.lifecycle.ViewModel
import com.cheezycode.notesample.models.UserRequest
import com.example.retrofitandroom.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class ViewModels @Inject constructor(val userRepository: UserRepository): ViewModel(){

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