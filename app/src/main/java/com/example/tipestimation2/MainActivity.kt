package com.example.tipestimation2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculate_tip : Button = findViewById(R.id.button)

        calculate_tip.setOnClickListener{
            val bill_amount : EditText = findViewById(R.id.editTextNumberDecimal)
            val service_quality : RadioGroup = findViewById(R.id.radioGroup)
            val display_tip : TextView = findViewById(R.id.textView5)

            var amount = bill_amount.getText().toString()
            if (amount == "" )                              //if number than amount == null
            {
                display_tip.text = "Enter amount first!"
            }
            else
            {
                var final_amount = amount.toDouble()
                var tip_percentage = when(service_quality.checkedRadioButtonId){
                    R.id.radioButton4 -> 0.20
                    R.id.radioButton5 -> 0.18
                    else -> 0.15
                }
                final_amount = final_amount * tip_percentage

                var roundUp : Switch = findViewById(R.id.switch1)
                var round_up_status = roundUp.isChecked
                if (round_up_status) {
                    final_amount = ceil(final_amount)
                }

                display_tip.text = "Tip Amount : ${final_amount.toString()}"
            }


        }

    }
}