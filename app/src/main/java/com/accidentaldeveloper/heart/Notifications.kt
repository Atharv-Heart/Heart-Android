package com.accidentaldeveloper.heart
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.accidentaldeveloper.heart.models.mascot_model.mascot_request
import com.accidentaldeveloper.heart.viewmodel.Mascot_View_Model
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Notifications : AppCompatActivity() {
    private val viewmodel:Mascot_View_Model by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        viewmodel.livedata.observe(this,{
            Log.d("aajana", "onCreate: ${it}")
        })

        val newQuery = mascot_request("tell me about goku")
        viewmodel.getdata(newQuery)

    }
}