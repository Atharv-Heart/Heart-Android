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
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArFragmentBinding.inflate(layoutInflater, container, false)
        /*binding.im1.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.setClassName("com.accidentaldeveloper.ar", "com.accidentaldeveloper.ar.MainActivity")
            i.putExtra("vinit", "1")
            startActivity(i)

        }

        binding.im2.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.setClassName("com.accidentaldeveloper.ar", "com.accidentaldeveloper.ar.MainActivity")
            i.putExtra("vinit", "2")
            startActivity(i)

        }

        binding.im3.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.setClassName("com.accidentaldeveloper.ar", "com.accidentaldeveloper.ar.MainActivity")
            i.putExtra("vinit", "3")
            startActivity(i)

        }*/

        binding.imageView2.setOnClickListener {
            val unityIntent = Intent()
            unityIntent.action = Intent.ACTION_VIEW
            unityIntent.setClassName("com.HeART.ARRestore", "com.unity3d.player.UnityPlayerActivity")
            startActivity(unityIntent)
        }

        return binding.root
    }


}


//com.Dini.PlanetsAR