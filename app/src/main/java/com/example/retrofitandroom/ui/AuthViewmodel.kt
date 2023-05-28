package com.example.retrofitandroom.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheezycode.notesample.models.UserRequest
import com.example.retrofitandroom.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewmodel @Inject constructor(private val repository: UserRepository) : ViewModel(){

    fun registerUser(userRequest: UserRequest) {
        viewModelScope.launch {
            repository.registerUser(userRequest)
        }
    }


    fun signinUser(userRequest: UserRequest){
        viewModelScope.launch {
            repository.signinUser(userRequest)
        }
    }
}