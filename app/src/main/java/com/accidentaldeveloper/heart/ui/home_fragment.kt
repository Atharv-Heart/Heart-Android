package com.accidentaldeveloper.heart.ui

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.accidentaldeveloper.heart.Gallery
import com.accidentaldeveloper.heart.R
import com.accidentaldeveloper.heart.Visited_Places
import com.accidentaldeveloper.heart.adapters.ImageAdapter
import com.accidentaldeveloper.heart.databinding.FragmentHomeBinding
import com.accidentaldeveloper.heart.models.mascot_model.mascot_request
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.AdvertimentViewModel
import com.accidentaldeveloper.heart.viewmodel.Mascot_View_Model
import com.unity3d.ads.IUnityAdsShowListener
import com.unity3d.ads.UnityAds
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
    private val imageUrls = listOf(
        "https://res.cloudinary.com/dlfd6tfmu/image/upload/v1699005325/atharvFolder/cchgdhdbehapmifs3yhm.png",
        "https://www.startpage.com/av/proxy-image?piurl=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.Urjyzf7GBJobBFPkDNCEQQHaEg%26pid%3DApi&sp=1699015396T501729de04ec3b1bcbc716a1a4dab420e410eadbf2c633cf1140712a5d343f5f",
        "https://www.startpage.com/av/proxy-image?piurl=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.jUy3sDfVdykhATRUq14cVAHaE8%26pid%3DApi&sp=1699015425T5461804bc0dac2733fb4a7762a4f5cae9f4846dbf930dc8d466c60fe4fd3bdfb",
        "https://www.startpage.com/av/proxy-image?piurl=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.yOrG-QZR1Yg7270dK90MhgHaEK%26pid%3DApi&sp=1699015460T8bc6e394a81a799d410fa91b0e6cbed2cdc5bd74ed3a6e036c96ce96e1c631b9",
        "https://res.cloudinary.com/dlfd6tfmu/image/upload/v1699042654/atharvDealsImagesSample/images_hseflm.jpg"


    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val recyclerView = binding.NearbyPlaceRv
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,true)
        val adapter = ImageAdapter(imageUrls)
        recyclerView.adapter = adapter



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