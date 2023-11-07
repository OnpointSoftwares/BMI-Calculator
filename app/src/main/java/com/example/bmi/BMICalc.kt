package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth

class BMICalc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalc)
        val res=findViewById<TextView>(R.id.res)
        val weight: EditText =findViewById(R.id.txtWeight)
        val height: EditText =findViewById(R.id.txtHeight)
        val auth: FirebaseAuth = FirebaseAuth.getInstance()
        val btnCalculate: Button =findViewById(R.id.btnCalculate)
        btnCalculate.setOnClickListener {
            calculate(weight.text.toString(),height.text.toString())
        }
    }

    private fun calculate(weight: String, height: String) {
        val h=height.toInt()
        val bmi=weight.toInt()/(h*h)
        if(bmi<18.5) {
            findViewById<TextView>(R.id.res).text="${bmi} You are underweight"
        }
        else if(bmi<24.9)
        {
            findViewById<TextView>(R.id.res).text="${bmi} You are of healthy weight"
        }
        else if(bmi<29.9)
        {

        }
        else{
            findViewById<TextView>(R.id.res).text="${bmi} You are overweight"
        }
        }
    }