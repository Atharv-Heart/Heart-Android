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
import com.accidentaldeveloper.heart.databinding.FragmentAllEventsFragmentsBinding
import com.accidentaldeveloper.heart.models.heart_events_model.events_responseItem
import com.accidentaldeveloper.heart.viewmodel.HeartViewModel.EventsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class All_Events_fragments : Fragment() {
    lateinit var binding:FragmentAllEventsFragmentsBinding
    private val viewmodel: EventsViewModel by viewModels()
    lateinit var recylerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    lateinit var eventsArrayList: ArrayList<events_responseItem>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAllEventsFragmentsBinding.inflate(layoutInflater,container,false)
        //  val navController = findNavController()

        binding.savedBtn.setOnClickListener {
            // Navigate to Fragment2
            findNavController().navigate(R.id.action_all_Events_fragments_to_saved_Events_Fragments)
        }





        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        recylerView = view.findViewById(R.id.events_rv)
        recylerView.layoutManager = layoutManager
        recylerView.setHasFixedSize(true)
        //myAdapter = MyAdapter(eventsArrayList) // Initialize myAdapter here

        viewmodel.liveData.observe(viewLifecycleOwner, { data ->
            myAdapter = MyAdapter(data)
            recylerView.adapter = myAdapter
            Log.d("events", "onCreate: $data")
        })



    }

}