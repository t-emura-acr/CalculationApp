package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var mTextResult: TextView

    companion object {

        private const val CHAR_PLUS = "+"

        private const val CHAR_MINUS = "-"

        private const val CHAR_MULTIPLY = "×"

        private const val CHAR_DIVIDE = "÷"

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        mTextResult = findViewById(R.id.textView)



        val btn00:Button = findViewById(R.id.btn0)
        val btn01:Button = findViewById(R.id.btn1)
        val btn02:Button = findViewById(R.id.btn2)
        val btn03:Button = findViewById(R.id.btn3)
        val btn04:Button = findViewById(R.id.btn4)
        val btn05:Button = findViewById(R.id.btn5)
        val btn06:Button = findViewById(R.id.btn6)
        val btn07:Button = findViewById(R.id.btn7)
        val btn08:Button = findViewById(R.id.btn8)
        val btn09:Button = findViewById(R.id.btn9)
        val btn09:Button = findViewById(R.id.btn9)
        val btnWaru: Button = findViewById(R.id.btnWaru)
        val btnKakeru: Button = findViewById(R.id.btnKakeru)
        val btnMainasu: Button = findViewById(R.id.btnMainasu)
        val btnPurasu: Button = findViewById(R.id.btnPurasu)
        val btnIkore: Button = findViewById(R.id.btnIkore)
        val btnC: Button = findViewById(R.id.btnC)



        btn00.setOnClickListener(listener)
        btn01.setOnClickListener(listener)
        btn02.setOnClickListener(listener)
        btn03.setOnClickListener(listener)
        btn04.setOnClickListener(listener)
        btn05.setOnClickListener(listener)
        btn06.setOnClickListener(listener)
        btn07.setOnClickListener(listener)
        btn08.setOnClickListener(listener)
        btn09.setOnClickListener(listener)
        btnWaru.setOnClickListener(listener)
        btnKakeru.setOnClickListener(listener)
        btnMainasu.setOnClickListener(listener)
        btnPurasu.setOnClickListener(listener)
        btnIkore.setOnClickListener(listener)
        btnC.setOnClickListener(listener)
    }

    private val listener = object : View.OnClickListener {

        override fun onClick(view: View?) {

            if (view == null) {
                 return
            }

            val btn: Button = view.findViewById(view.id)

            var afterValue = ""

            when(button.id){

                R.id.btn0 -> {

                    if(mTextResult.text.isNotEmpty()){

                        mTextResult.text = String.format("%$%$", mTextResult.text, button.text)
                    }
                }
                R.id.btn1,
                R.id.btn2,
                R.id.btn3,
                R.id.btn4,
                R.id.btn5,
                R.id.btn6,
                R.id.btn7,
                R.id.btn8,
                R.id.btn9  -> {
                    mTextResult.text = String.format("%$%$", mTextResult.text, button.text)
                }

                R.id.btnIkore -> {
                executeCalc()
                }

                R.id.btnC -> {
                    mTextResult.text = ""
                }

            }
        }

    }


    var value:int= 0




}
