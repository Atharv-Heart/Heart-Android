package com.accidentaldeveloper.heart.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.accidentaldeveloper.heart.MainActivity
import com.accidentaldeveloper.heart.R
import com.accidentaldeveloper.heart.databinding.FragmentLogInBinding
import com.accidentaldeveloper.heart.helper.NetworkResult
import com.accidentaldeveloper.heart.helper.TokenManager
import com.accidentaldeveloper.heart.models.heart_auth_model.singup_and_login_request
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LogIn_Fragment : Fragment() {
    lateinit var binding: FragmentLogInBinding
    private val authViewModel by viewModels<AuthViewModel>()

    @Inject
    lateinit var tokenManager: TokenManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLogInBinding.inflate(layoutInflater,container,false)

        if(tokenManager.getToken()!=null){
            Log.d("token", "onCreateView: ${tokenManager.getToken()}")
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ClickListner for login
        binding.loginBtn.setOnClickListener{
            val validateResult = validateUserInput()
            if (validateResult.first) {
                authViewModel.login(getUserRequest())
            } else {
                Toast.makeText(context, "${validateResult.second}", Toast.LENGTH_SHORT).show()
            }

        }

        //clickListner for register
        binding.createNewAccount.setOnClickListener {
            findNavController().navigate(R.id.action_logIn_Fragment_to_register_Fragment)
        }

        bind_Observer()

    }

    private fun getUserRequest():singup_and_login_request{
        val email_userName = binding.usernameLogin.text.toString()
        val password = binding.passwordLogin.text.toString()
        return singup_and_login_request(email_userName,password)
    }
    private fun validateUserInput(): Pair<Boolean, String> {
        val userRequest = getUserRequest()
        return authViewModel.validateCreditials(userRequest.username, userRequest.password)
    }

    private fun bind_Observer() {
        authViewModel.userResponseLiveDataforlogin.observe(viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> {
                    binding.pgBar.isVisible = false
                    tokenManager.saveToken(it.data!!.token)
                    val intent = Intent(context, MainActivity::class.java)
                    startActivity(intent)
                }

                is NetworkResult.Error -> {
                    binding.pgBar.isVisible = false
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }

                is NetworkResult.Loading -> {
                    binding.pgBar.isVisible = true
                }
            }
        })
    }




}