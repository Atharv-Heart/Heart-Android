package com.accidentaldeveloper.heart.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.accidentaldeveloper.heart.R
import com.accidentaldeveloper.heart.adapters.MyAdapter
import com.accidentaldeveloper.heart.databinding.FragmentEventsFragmentBinding
import com.accidentaldeveloper.heart.models.advertisements_model.advertisements_response
import com.accidentaldeveloper.heart.models.heart_events_model.events_response
import com.accidentaldeveloper.heart.models.heart_events_model.events_responseItem
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.EventsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class events_fragment : Fragment() {
    lateinit var binding: FragmentEventsFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEventsFragmentBinding.inflate(layoutInflater, container, false)

       /* binding.savedBtn.setOnClickListener {
            findNavController().navigate(R.id.action_all_Events_fragments_to_saved_Events_Fragments)
        }*/

        return binding.root

    }





}
