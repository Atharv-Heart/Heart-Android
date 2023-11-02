package com.accidentaldeveloper.heart.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController


import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.navigateUp
import com.accidentaldeveloper.heart.R
import com.accidentaldeveloper.heart.databinding.FragmentEventsFragmentBinding


class events_fragment : Fragment() {
    lateinit var binding:FragmentEventsFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
          binding = FragmentEventsFragmentBinding.inflate(layoutInflater,container,false)






        return binding.root
    }



}