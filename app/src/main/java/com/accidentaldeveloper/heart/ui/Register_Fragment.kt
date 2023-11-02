package com.accidentaldeveloper.heart.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.accidentaldeveloper.heart.R
import com.accidentaldeveloper.heart.databinding.FragmentRegisterBinding
import com.accidentaldeveloper.heart.helper.NetworkResult
import com.accidentaldeveloper.heart.models.heart_auth_model.singup_and_login_request
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Register_Fragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    private val authViewModel by viewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //clickListener for creating Account
        binding.createAcc.setOnClickListener {
            val validateResult = validateUserInput()
            if (validateResult.first) {
                authViewModel.registerUser(getUserRequest())
            } else {
                Toast.makeText(context, "${validateResult.second}", Toast.LENGTH_SHORT).show()
            }

        }

        binding.alreadyHaveAnAccount.setOnClickListener {
            findNavController().navigate(R.id.action_register_Fragment_to_logIn_Fragment)
        }

        //observer
        bind_Observer()
    }

    private fun getUserRequest():singup_and_login_request{
        val email_userName = binding.usernameReg.text.toString()
        val password = binding.password.text.toString()
        return singup_and_login_request(email_userName,password)
    }
    private fun validateUserInput(): Pair<Boolean, String> {
        val userRequest = getUserRequest()
        return authViewModel.validateCreditials(userRequest.username, userRequest.password)
    }

    private fun bind_Observer() {
        authViewModel.userResponseLiveDataforsignup.observe(viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> {
                    binding.pgBar.isVisible = false
                    findNavController().navigate(R.id.action_register_Fragment_to_logIn_Fragment)
                }

                is NetworkResult.Error -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }

                is NetworkResult.Loading -> {
                    binding.pgBar.isVisible = true
                }
            }
        })
    }


}