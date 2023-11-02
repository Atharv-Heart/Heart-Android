package com.accidentaldeveloper.heart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.accidentaldeveloper.heart.databinding.ActivityMainBinding
import com.accidentaldeveloper.heart.viewmodel.Mascot_View_Model
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewmodel: Mascot_View_Model by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //navigation component
        val navController = findNavController(R.id.fragment)
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)

        //onClickListerner for notification
        binding.notification.setOnClickListener {
            startActivity(Intent(this@MainActivity, Notifications::class.java))
        }

        //onClickListerner for notification
        binding.qr.setOnClickListener {
            startActivity(Intent(this@MainActivity, QR::class.java))
        }

        //onClickListerner for question_help
        binding.question.setOnClickListener {
            startActivity(Intent(this@MainActivity, question_help::class.java))
        }


//testing code api k liye....

        /* val retrofit = Retrofit
                .Builder()
                .baseUrl(AppConstant.MASCOT_BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)



            lifecycleScope.launch {
               val retrofirData =  retrofit.getDataForMascot(apiHost = AppConstant.MASCOT_HOST_HEADER, apiKey = AppConstant.MASCOT_API_KEY, request = mascot_request("reva"))
               val response =  retrofirData.execute()
                if(response.isSuccessful){
                    val responseBody = response.body()
                     Log.d("aaja", "onCreate: ${responseBody.toString()}")
                }else{
                    Log.d("error", "onCreate: ${response.errorBody().toString()}")
                }

            }*/


    }
}