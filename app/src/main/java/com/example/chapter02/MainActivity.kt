package com.example.chapter02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // activity_main을 가져와서 contentView로 설정하겠다는 것
                                                // 주소 값으로 저장함 R을 통해서 주소값을 가지고 옴
                                                // R은 R파일을 말함 그냥 파일의 주소값을 저장혹 있는 것 이라고 생각하면 됨
        val heightEditText: EditText = findViewById(R.id.heightEditText) // heightEditText는 EditText라는 type으로 main_activity에 있는 heightEditText의 값을 가지고 온다
        val weightEditText = findViewById<EditText>(R.id.weightEditText) //주소 값을 통해서 할당 했기 때문에 type을 지정해 줘야함

        val resultButton: Button = findViewById(R.id.resultButton)


        resultButton.setOnClickListener{

            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                Toast.makeText(this,"값을 넣어주세요.",Toast.LENGTH_SHORT).show()
                //경고 문구를 띄움 show를 넣어줘야함 text는 어떤 문구를 넣을지 Toast는 LENGTH는 길이
                return@setOnClickListener

                //setOnclickLinstener를 나가주겠다

            }

            val height = heightEditText.text.toString().toInt()  // heightEditText의 값이 Int가 아니가에 string으로 치환후 toInt로 반환해준다
            val weight = weightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height",height)
            intent.putExtra("weight",weight)
            startActivity(intent)

            
        }  //클릭이 일어나는 것을 linster 듣는 함수 setOnClickLinstener

    }
}

// 디버깅 버그를 잡는다
