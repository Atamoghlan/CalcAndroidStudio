package com.example.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var result_text:TextView
    private lateinit var plus_button:TextView
    private lateinit var minus_button:TextView
    private lateinit var division_button:TextView
    private lateinit var multiply_button:TextView
    private var FirstNum: Double = 0.0
    private var SecondNum: Double = 0.0
    private var MathSign = false
    private var str: String = ""
    private var Operation: Int = 0
    private var IsNull = false
    private var DotExist = true
    private var PlusExist = false
    private var MinusExist = false
    private var DivisionExist = false
    private var MultiplyExist = false
    private var NumExist = false
    private var NullAndDot = false
    private var EqualWork = false
    private var DividedByZero = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result_text= findViewById(R.id.result_text)
        division_button = findViewById(R.id.division)
        plus_button = findViewById(R.id.plus)
        minus_button = findViewById(R.id.minus)
        multiply_button = findViewById(R.id.multiply)
    }
    fun DigitsTag(view: View){
        if (MathSign == true)
        {

            if (view.tag == "10" && DotExist == false && NumExist == true && IsNull == false){ //сюда заходит при втором числе
                str += "."
                result_text.text = str
                DotExist = true
                NumExist = false
            }
            else if (view.tag == "10" && DotExist == false && NumExist == true && IsNull == true){
                str += "."
                result_text.text = str
                DotExist = true
                NumExist = false
                IsNull = false
                NullAndDot = true
            }

            else if(IsNull == false && view.tag == "0")
            {
                str += view.tag.toString()
                result_text.text = str
                IsNull = true
                NumExist = true
                DotExist = false
            }
            else if (IsNull == true && NullAndDot == false && view.tag != "10")
            {
                str = view.tag.toString()
                result_text.text = str
                NumExist = true
                DotExist = false
            }
            else if (view.tag != "10" && view.tag != "0"){
                str += view.tag.toString()
                result_text.text = str
                NumExist = true
                MathSign = false
                DotExist = false
            }
            EqualWork = true
        }
        else { //сюда заходит при первом числе числе
            if (view.tag == "10" && NumExist == true && DotExist == false && IsNull == false)
            {
                str += "."
                result_text.text = str
                DotExist = true
                NumExist = false

            }
            else if (view.tag == "10" && DotExist == false && NumExist == true && IsNull == true){ //сюда заходит при первом числе
                str += "."
                result_text.text = str
                DotExist = true
                NumExist = false
                IsNull = false
                NullAndDot = true
            }
            else if(IsNull == false && view.tag == "0")
            {
                str += view.tag.toString()
                result_text.text = str
                IsNull = true
                NumExist = true
                DotExist = false
            }
            else if (IsNull == true && NullAndDot == false && view.tag != "10")
            {
                str = view.tag.toString()
                result_text.text = str
                NumExist = true
                DotExist = false
            }
            else if (view.tag != "10" && view.tag != "0"){
                str += view.tag.toString()
                result_text.text = str
                NumExist = true
                DotExist = false
            }
            //SecondNum = result_text.text.toString().toDouble()
        }
    }

    fun Ops(view: View){
        if (result_text.text != "" && view.tag!= "10" && view.tag!= "11" && view.tag!= "16" && !PlusExist && !MinusExist && !MultiplyExist && !DivisionExist && DividedByZero == false && NumExist == true){
            DotExist = true
            IsNull = false
            str=""
            FirstNum = result_text.text.toString().toDouble()
            if (view.tag == "12" && NumExist === true)
            {
                result_text.text = "+"
                PlusExist = true
                NumExist = false

            }
            else if (view.tag == "13" && NumExist === true)
            {
                result_text.text = "-"
                MinusExist = true
                NumExist = false
            }
            else if (view.tag == "14" && NumExist === true)
            {
                result_text.text = "*"
                MultiplyExist = true
                NumExist = false
            }
            else if (view.tag == "15" && NumExist === true)
            {
                result_text.text = "/"
                DivisionExist = true
                NumExist = false
            }
            Operation = view.tag.toString().toInt()
            MathSign = true


        }
        else if (view.tag == "11" && EqualWork == true)
        {
            SecondNum = result_text.text.toString().toDouble()
            if (Operation == 15)
            {
                if (FirstNum == 0.0)
                {
                    result_text.text = ("Error").toString()
                    DividedByZero = true
                }
                else
                {
                    result_text.text = ("%.3f".format((FirstNum/SecondNum))).toString()
                    FirstNum = result_text.text.toString().toDouble()
                }
            }
            else if (Operation == 14 )
            {
                result_text.text = ("%.3f".format((FirstNum*SecondNum))).toString()
                FirstNum = result_text.text.toString().toDouble()
            }
            else if (Operation == 13 )
            {
                result_text.text = ("%.3f".format((FirstNum-SecondNum))).toString()
                FirstNum = result_text.text.toString().toDouble()
            }
            else if (Operation == 12)
            {
                result_text.text = ("%.3f".format((FirstNum+SecondNum))).toString()
                FirstNum = result_text.text.toString().toDouble()
            }

            SecondNum = 0.0
            str = ""
            DotExist = true
            PlusExist = false
            MinusExist = false
            DivisionExist = false
            MultiplyExist = false
            NumExist = true
            IsNull = false
            EqualWork = false
        }
        else if (view.tag == "16")
        {
            result_text.text = " "
            SecondNum=0.0
            FirstNum=0.0
            Operation=0
            str = ""
            MathSign = false
            IsNull = false
            DotExist = true
            PlusExist = false
            MinusExist = false
            DivisionExist = false
            MultiplyExist = false
            NumExist = false
            EqualWork = false
            DividedByZero = false
        }


    }

}