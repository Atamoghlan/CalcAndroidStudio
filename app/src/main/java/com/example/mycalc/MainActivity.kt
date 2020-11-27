package com.example.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var result_text:TextView

    private var FirstNum: Double = 0.0
    private var SecondNum: Double = 0.0
    private var MathSign = false
    private var str: String = ""
    private var Operation: Int = 0
    private var IsNull = false
    private var DotExist = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result_text= findViewById(R.id.result_text)
    }

    fun DigitsTag(view: View){
        if (MathSign == true)
        {
            if (view.tag == "10" && IsNull == false && DotExist == false){ //сюда заходит при первом числе
                str += "."
                result_text.text = str
                IsNull = true
                DotExist == true
            }
            str+=view.tag.toString()
            result_text.text = str
            MathSign = false
            SecondNum = result_text.text.toString().toDouble()
            str = ""
        }
        else { //сюда заходит при числе числе
            if (view.tag == "10" && IsNull == false && DotExist == false){

                str += "."
                result_text.text = str
                IsNull = true
            }
            str += view.tag.toString()
            result_text.text=str
            SecondNum = result_text.text.toString().toDouble()
            str = ""
        }



    }

    fun Ops(view: View){
        if (result_text.text != "" && view.tag!= "10" && view.tag!= "11" && view.tag!= "16"){

            FirstNum = result_text.text.toString().toDouble()
            if (view.tag == "12")
            {
                result_text.text = "+"
            }
            else if (view.tag == "13")
            {
                result_text.text = "-"
            }
            else if (view.tag == "14")
            {
                result_text.text = "*"
            }
            else if (view.tag == "15")
            {
                result_text.text = "/"
            }
            Operation = view.tag.toString().toInt()
            MathSign = true


        }
        else if (view.tag == "11")
        {
            if (Operation == 15)
            {
                if (FirstNum == 0.0)
                {
                    result_text.text = ("Error").toString()
                }
                else
                {
                    result_text.text = (FirstNum/SecondNum).toString()
                }
            }
            else if (Operation == 14)
            {
                result_text.text = (FirstNum*SecondNum).toString()
            }
            else if (Operation == 13)
            {
                result_text.text = (FirstNum-SecondNum).toString()
            }
            else if (Operation == 12)
            {
                result_text.text = (FirstNum+SecondNum).toString()
            }
            FirstNum = result_text.text.toString().toDouble()
            SecondNum = 0.0
            str == ""
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
            DotExist = false
        }


    }

}