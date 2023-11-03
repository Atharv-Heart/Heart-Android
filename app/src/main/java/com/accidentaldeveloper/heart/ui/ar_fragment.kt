package com.accidentaldeveloper.heart.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.accidentaldeveloper.heart.databinding.FragmentArFragmentBinding



class ar_fragment : Fragment() {
    lateinit var binding: FragmentArFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = FragmentArFragmentBinding.inflate(layoutInflater,container,false)
        binding.imageView2.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.setClassName("com.DefaultCompany.ProtoTypical","com.unity3d.player.UnityPlayerActivity")


            startActivity(i)

        }


        return binding.root
    }


}




//com.Dini.PlanetsAR