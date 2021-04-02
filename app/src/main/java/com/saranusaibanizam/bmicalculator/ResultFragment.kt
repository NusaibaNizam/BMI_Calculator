package com.saranusaibanizam.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.saranusaibanizam.bmicalculator.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var binding:FragmentResultBinding
    private val inputViewModel: InputViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentResultBinding.inflate(inflater)
        inputViewModel.statusString.observe(viewLifecycleOwner, Observer {
            binding.statusTV.text=it
        })
        inputViewModel.bmiString.observe(viewLifecycleOwner, Observer {
            binding.bmiTV.text=it
        })
        inputViewModel.weightString.observe(viewLifecycleOwner, Observer {
            binding.weightTV.text=it
        })
        inputViewModel.heightString.observe(viewLifecycleOwner, Observer {
            binding.heightTV.text=it
        })
        return binding.root
    }

}