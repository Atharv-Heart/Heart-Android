package com.accidentaldeveloper.heart
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.accidentaldeveloper.heart.databinding.ActivityLoginSingUpScreenBinding
import com.accidentaldeveloper.heart.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Login_Sing_Up_Screen : AppCompatActivity() {
    lateinit var binding: ActivityLoginSingUpScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSingUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}