package com.example.retrofitandroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.cheezycode.notesample.models.UserRequest
import com.example.retrofitandroom.databinding.FragmentRegisterBinding
import com.example.retrofitandroom.ui.AuthViewmodel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
     private  val authviewmodel by viewModels<AuthViewmodel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.register.setOnClickListener {
            //findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            authviewmodel.registerUser(UserRequest("abc.com", "12345","101103"))

        }
        binding.login.setOnClickListener {
           // findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            authviewmodel.registerUser(UserRequest("abc.com", "12345","101103"))

        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}