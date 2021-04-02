package com.saranusaibanizam.bmicalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.saranusaibanizam.bmicalculator.databinding.FragmentInputBinding


class InputFragment : Fragment() {
    private lateinit var binding:FragmentInputBinding
    private val inputViewModel: InputViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentInputBinding.inflate(inflater)
        var weightInKG=50
        var feet=5
        var inches=0
        binding.weightCounter.setNumber("50",true)
        binding.weightCounter.setOnValueChangeListener { view, oldValue, newValue ->
            weightInKG = newValue
        }
        binding.feetCounter.setNumber("5",true)
        binding.feetCounter.setOnValueChangeListener { view, oldValue, newValue ->
            feet = newValue
        }

        binding.inchCounter.setOnValueChangeListener { view, oldValue, newValue ->
            inches = newValue
        }
        binding.calculateBtn.setOnClickListener {
            inputViewModel.calculateBMI(weightInKG,feet,inches)
            findNavController().navigate(R.id.resultFragment)
        }
        return binding.root
    }


}