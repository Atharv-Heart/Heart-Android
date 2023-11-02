package com.accidentaldeveloper.heart.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.accidentaldeveloper.heart.R
import com.accidentaldeveloper.heart.databinding.FragmentDealsFragmentsBinding
import com.accidentaldeveloper.heart.databinding.FragmentLogInBinding
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.DealsViewModel
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.EventsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class deals_fragments : Fragment() {
    lateinit var binding: FragmentDealsFragmentsBinding
    private val viewmodel: DealsViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = FragmentDealsFragmentsBinding.inflate(layoutInflater,container,false)
       val view = binding.root

       viewmodel.livedata.observe(viewLifecycleOwner,{
           Log.d("deals", "onCreateView: ${it}")
       })

        return (view)
    }


}