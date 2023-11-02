package com.accidentaldeveloper.heart.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.accidentaldeveloper.heart.R
import com.accidentaldeveloper.heart.databinding.FragmentAllEventsFragmentsBinding

class All_Events_fragments : Fragment() {
    lateinit var binding:FragmentAllEventsFragmentsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAllEventsFragmentsBinding.inflate(layoutInflater,container,false)
        //  val navController = findNavController()

        binding.savedBtn.setOnClickListener {
            // Navigate to Fragment2
            findNavController().navigate(R.id.action_all_Events_fragments_to_saved_Events_Fragments)
        }





        return binding.root
    }


}