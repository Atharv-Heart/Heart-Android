package com.accidentaldeveloper.heart.ui

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.accidentaldeveloper.heart.Gallery
import com.accidentaldeveloper.heart.Visited_Places
import com.accidentaldeveloper.heart.databinding.FragmentHomeBinding
import com.accidentaldeveloper.heart.models.mascot_model.mascot_request
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.AdvertimentViewModel
import com.accidentaldeveloper.heart.viewmodel.Mascot_View_Model
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class home_fragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    private val viewmodel: Mascot_View_Model by viewModels()
    private val viewmodel_Ads: AdvertimentViewModel by viewModels()

    lateinit var tts: TextToSpeech
    lateinit var speak: String
    private var counter:Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        //onclickListner for gallery visited
        binding.gallery.setOnClickListener {
            val intent = Intent(context, Gallery::class.java)
            startActivity(intent)
        }

        //onclickListner for places visited
        binding.visited.setOnClickListener {
            val intent = Intent(context, Visited_Places::class.java)
            startActivity(intent)
        }

        //onClickListner for refer and win
        binding.referandwin.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody = "Download now to restore historical monuments, play games, complete missions, and earn 100 coins for your efforts."+" https://deluxe-puffpuff-72d8f1.netlify.app/ "
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(sharingIntent, "Share via"))
        }

        //more coins
        binding.morecoins.setOnClickListener {

        }

        viewmodel.livedata.observe(viewLifecycleOwner, {
            Log.d("aajana", "onCreate: ${it}")
            speak = it.response
        })

        val newQuery = mascot_request("tell me about naruto")
        viewmodel.getdata(newQuery)

        binding.dragImgView.setOnClickListener {
            tts = TextToSpeech(context, TextToSpeech.OnInitListener {
                tts.language = Locale.ENGLISH
                tts.setPitch(1f)
                if(counter==0){
                    tts.speak("REVA University Rangasthala: State-of-the-art amphitheater for all types of events.", TextToSpeech.QUEUE_ADD, null)
                    counter++;
                }else if(counter==1){
                    tts.stop()
                    tts.speak("Rangasthala: Where culture, commerce, and community converge", TextToSpeech.QUEUE_ADD, null)
                    counter++;
                }else if(counter==2){
                    tts.stop()
                    tts.speak("Rangasthala: The heart of REVA University, beating with the rhythm of life", TextToSpeech.QUEUE_ADD, null)
                    counter=0;
                }


            })
        }


        //ads_viewmodel
        viewmodel_Ads.advertismentLiveData.observe(viewLifecycleOwner,{
            Log.d("ads", "onCreateView: ${it}")
        })
        return binding.root
    }


}