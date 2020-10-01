package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var operator_var = ""
    private var first_num = ""
    private var second_num = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Calculator"
    }
    fun onClick(view : View){
        when(view.id){
            R.id.btn_0 -> addNum("0")
            R.id.btn_1 -> addNum("1")
            R.id.btn_2 -> addNum("2")
            R.id.btn_3 -> addNum("3")
            R.id.btn_4 -> addNum("4")
            R.id.btn_5 -> addNum("5")
            R.id.btn_6 -> addNum("6")
            R.id.btn_7 -> addNum("7")
            R.id.btn_8 -> addNum("8")
            R.id.btn_9 -> addNum("9")
            R.id.btn_equal -> calculate()
            R.id.btn_plus -> operator("+")
            R.id.btn_minus -> operator("-")
            R.id.btn_multiply -> operator("*")
            R.id.btn_division -> operator("/")
            R.id.btn_clear -> clearing()

        }
    }

    private fun addNum(num: String) {
        result_txt.append(num)
    }

    private fun clearing() {
        result_txt.text=""
        operator_txt.text=""
        first_num=""
        second_num=""
        operator_var=""
    }

    private fun operator(operator: String) {

        if(result_txt.text.isEmpty() && first_num.isEmpty()){
            Toast.makeText(this , "مقداری وارد نشده است" ,Toast.LENGTH_SHORT).show()
            return
        }

        if(operator_var.isEmpty()){
            operator_var = operator
            first_num = result_txt.text.toString()
            operator_txt.text = operator
            result_txt.text = ""
        }else{
            if (result_txt.text.isNotEmpty()){
                second_num = result_txt.text.toString()
            }
            if(first_num.isNotEmpty() && second_num.isEmpty()){
                operator_var = operator
                operator_txt.text = operator
            }else{
                return
            }
        }
    }

    private fun calculate() {
        if(first_num.isEmpty()){
            Toast.makeText(this , "یک عدد وارد کنید" ,Toast.LENGTH_SHORT).show()
            return
        }else if(second_num.isEmpty() && result_txt.text.isEmpty()){
            Toast.makeText(this , "یک عدد وارد کنید" ,Toast.LENGTH_SHORT).show()
            return
        }else{
            second_num = result_txt.text.toString()
        }
        val first = first_num.toInt()
        val second = second_num.toInt()

        val result = when(operator_var){
            "+" -> first+second
            "-" -> first-second
            "*" -> first*second
            else -> first/second
        }
        operator_txt.text = "="
        result_txt.text = result.toString()
    }
}