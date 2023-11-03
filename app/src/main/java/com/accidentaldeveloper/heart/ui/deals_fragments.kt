package com.accidentaldeveloper.heart.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.accidentaldeveloper.heart.R
import com.accidentaldeveloper.heart.adapters.ImageAdapter
import com.accidentaldeveloper.heart.adapters.bannerAdsAdapter
import com.accidentaldeveloper.heart.databinding.FragmentDealsFragmentsBinding
import com.accidentaldeveloper.heart.databinding.FragmentLogInBinding
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.DealsViewModel
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.EventsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class deals_fragments : Fragment() {
    lateinit var binding: FragmentDealsFragmentsBinding
    private val viewmodel: DealsViewModel by viewModels()
    private val imageUrls = listOf(
        "https://res.cloudinary.com/dlfd6tfmu/image/upload/v1699005325/atharvFolder/cchgdhdbehapmifs3yhm.png",
        "https://www.startpage.com/av/proxy-image?piurl=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.Urjyzf7GBJobBFPkDNCEQQHaEg%26pid%3DApi&sp=1699015396T501729de04ec3b1bcbc716a1a4dab420e410eadbf2c633cf1140712a5d343f5f",
        "https://www.startpage.com/av/proxy-image?piurl=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.jUy3sDfVdykhATRUq14cVAHaE8%26pid%3DApi&sp=1699015425T5461804bc0dac2733fb4a7762a4f5cae9f4846dbf930dc8d466c60fe4fd3bdfb",
        "https://www.startpage.com/av/proxy-image?piurl=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.yOrG-QZR1Yg7270dK90MhgHaEK%26pid%3DApi&sp=1699015460T8bc6e394a81a799d410fa91b0e6cbed2cdc5bd74ed3a6e036c96ce96e1c631b9",
        "https://res.cloudinary.com/dlfd6tfmu/image/upload/v1699042654/atharvDealsImagesSample/images_hseflm.jpg"



    )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = FragmentDealsFragmentsBinding.inflate(layoutInflater,container,false)
       val view = binding.root

        val recyclerView = binding.recylerviewdeal
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = bannerAdsAdapter(imageUrls)
        recyclerView.adapter = adapter


       viewmodel.livedata.observe(viewLifecycleOwner,{
           Log.d("deals", "onCreateView: ${it}")
       })

        return (view)
    }


}