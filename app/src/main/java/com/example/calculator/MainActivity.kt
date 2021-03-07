package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun buNumberEvent(view: View) {
        if (isNewOp) {
            edShowNumber.setText("")
        }
        isNewOp = false

        val buSelect = view as Button
        var buClickValue: String = edShowNumber.text.toString()

        when (buSelect.id) {
            // R -> Resources
            R.id.bu0 -> {
                buClickValue += "0"
            }
            R.id.bu1 -> {
                buClickValue += "1"
            }
            R.id.bu2 -> {
                buClickValue += "2"
            }
            R.id.bu3 -> {
                buClickValue += "3"
            }
            R.id.bu4 -> {
                buClickValue += "4"
            }
            R.id.bu5 -> {
                buClickValue += "5"
            }
            R.id.bu6 -> {
                buClickValue += "6"
            }
            R.id.bu7 -> {
                buClickValue += "7"
            }
            R.id.bu8 -> {
                buClickValue += "8"
            }
            R.id.bu9 -> {
                buClickValue += "9"
            }
            R.id.buDot -> {
                // Prevent more than one dot
                buClickValue += "."
            }
            R.id.buPlusMinues -> {
                buClickValue = "-" + buClickValue
            }
        }

        edShowNumber.setText(buClickValue)
    }

    var op = "*"
    var oldNumber = ""
    var isNewOp = true

    public fun buOpEvent(view: View) {
        val buSelect = view as Button
        var buClickValue: String = edShowNumber.text.toString()

        when (buSelect.id) {
            R.id.buMul -> {
                op = "*"
            }
            R.id.buDiv -> {
                op = "/"
            }
            R.id.buSub -> {
                op = "-"
            }
            R.id.buSum -> {
                op = "+"
            }
        }

        oldNumber = edShowNumber.text.toString()
        isNewOp = true
    }

    public fun buEqualEvent(view: View) {
        val newNumber = edShowNumber.text.toString()
        var finalNumber: Double? = null

        when(op) {
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
        }

        edShowNumber.setText(finalNumber.toString())
        isNewOp = true
    }
}