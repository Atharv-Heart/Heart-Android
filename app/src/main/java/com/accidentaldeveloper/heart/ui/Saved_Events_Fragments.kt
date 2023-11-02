package com.accidentaldeveloper.heart.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.accidentaldeveloper.heart.R
import com.accidentaldeveloper.heart.databinding.FragmentAllEventsFragmentsBinding
import com.accidentaldeveloper.heart.databinding.FragmentSavedEventsFragmentsBinding


class Saved_Events_Fragments : Fragment() {

     lateinit var binding: FragmentSavedEventsFragmentsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding  = FragmentSavedEventsFragmentsBinding.inflate(layoutInflater,container,false)


        binding.allEventsBtn.setOnClickListener {
            // Navigate to Fragment2
            findNavController().navigate(R.id.action_saved_Events_Fragments_to_all_Events_fragments)
        }




        return binding.root
    }

}