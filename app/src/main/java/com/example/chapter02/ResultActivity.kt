package com.example.chapter02

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) { //파일 실행시 호출이 되는 함수
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)

        val bmi = weight / (height / 100.0).pow(2.0) // 키를 미터 형식으로 바꾸기 위해 100으로 나누고 2제곱해준다(pow는 제곱근)

        val resultText = when{
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"

            else -> "저체중"
        }

        val resultValText = findViewById<TextView>(R.id.bmiTextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultTextView)

        resultValText.text = bmi.toString()
        resultStringTextView.text = resultText.toString()
    }
}