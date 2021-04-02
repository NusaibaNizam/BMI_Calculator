package com.saranusaibanizam.bmicalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saranusaibanizam.bmicalculator.databinding.FragmentInputBinding


class InputFragment : Fragment() {
    private lateinit var binding:FragmentInputBinding
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
            calculateBMI(weightInKG,feet,inches)
        }
        return binding.root
    }
    fun calculateBMI(weight:Int, ft:Int, inch:Int){
        val height:Double=((ft*12)+inch)*0.0254
        val bmi:Double=weight/(height*height)
        val bmi3digits:Double = Math.round(bmi * 1000.0) / 1000.0
        val bmi2digits:Double = Math.round(bmi3digits * 100.0) / 100.0
        val solutionBmi:Double = Math.round(bmi2digits * 10.0) / 10.0
        val status=when(solutionBmi){
            in 0.0..18.4->"Under Weight"
            in 18.5..24.9->"Normal Weight"
            in 25.0..29.9->"Normal Weight"
            in 30.0..34.9->"Normal Weight"
            in 35.0..39.9->"Normal Weight"
            else->"Obesity (Class 3)"
        }
        Log.e("TAG", "calculateBMI: $solutionBmi", )
    }


}