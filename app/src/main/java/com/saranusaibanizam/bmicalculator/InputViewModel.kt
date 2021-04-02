package com.saranusaibanizam.bmicalculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InputViewModel:ViewModel() {
    var heightString:MutableLiveData<String> = MutableLiveData()
    var weightString:MutableLiveData<String> =MutableLiveData()
    var bmiString:MutableLiveData<String> =MutableLiveData()
    var statusString:MutableLiveData<String> =MutableLiveData()
    fun calculateBMI(weight:Int, ft:Int, inch:Int){
        heightString.value="Height: $ft Feet $inch Inches"
        weightString.value="Weight: $weight KG"
        val height:Double=((ft*12)+inch)*0.0254
        val bmi:Double=weight/(height*height)
        val bmi3digits:Double = Math.round(bmi * 1000.0) / 1000.0
        val bmi2digits:Double = Math.round(bmi3digits * 100.0) / 100.0
        val solutionBmi:Double = Math.round(bmi2digits * 10.0) / 10.0
        bmiString.value="BMI: $solutionBmi"
        statusString.value=when(solutionBmi){
            in 0.0..18.4->"Under Weight"
            in 18.5..24.9->"Normal Weight"
            in 25.0..29.9->"Over Weight"
            in 30.0..34.9->"Obesity (Class 1)"
            in 35.0..39.9->"Obesity (Class 2)"
            else->"Obesity (Class 3)"
        }
    }

}