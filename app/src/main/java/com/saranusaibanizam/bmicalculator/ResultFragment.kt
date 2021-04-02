package com.saranusaibanizam.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.saranusaibanizam.bmicalculator.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var binding:FragmentResultBinding
    private val inputViewModel: InputViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentResultBinding.inflate(inflater)
        binding.statusTV.text=inputViewModel.statusString
        binding.bmiTV.text=inputViewModel.bmiString
        binding.weightTV.text=inputViewModel.weightString
        binding.heightTV.text=inputViewModel.heightString
        return binding.root
    }

}