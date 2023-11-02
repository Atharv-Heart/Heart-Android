package com.accidentaldeveloper.heart.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController


import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.navigateUp
import com.accidentaldeveloper.heart.R
import com.accidentaldeveloper.heart.databinding.FragmentEventsFragmentBinding
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.EventsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class events_fragment : Fragment() {
    lateinit var binding:FragmentEventsFragmentBinding
    private val viewmodel: EventsViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
          binding = FragmentEventsFragmentBinding.inflate(layoutInflater,container,false)

         viewmodel.liveData.observe(viewLifecycleOwner,{
            Log.d("events", "onCreate: ${it} ")
        })




        return binding.root
    }



}