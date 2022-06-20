package com.example.mynotes2.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mynotes2.R
import com.example.mynotes2.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit private var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.buttonAdd.setOnClickListener(){
            var action =HomeFragmentDirections.actionAddNote()
            Navigation.findNavController(it).navigate(action)
        }

    }

}