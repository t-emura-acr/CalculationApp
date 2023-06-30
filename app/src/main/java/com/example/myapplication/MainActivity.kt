package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.roundToLong

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
        mTextResult = findViewById(R.id.textView_result)



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

            when(btn.id){

                R.id.btn0 -> {

                    if(mTextResult.text.isNotEmpty()){

                        mTextResult.text = String.format("%s%s", mTextResult.text, btn.text)
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
                    mTextResult.text = String.format("%s%s", mTextResult.text, btn.text)
                }

                R.id.btnIkore -> {
                    executeCalc()
                }

                R.id.btnC -> {
                    mTextResult.text = "0"
                }

                R.id.btnPurasu -> {
                    if(mTextResult.text == ""){
                        return
                    }
                    when {
                        mTextResult.text.contains(CHAR_PLUS) -> {
                            return
                        }

                        mTextResult.text.contains(CHAR_MINUS) -> {
                            if (mTextResult.text.substring(0,1) == CHAR_MINUS) {
                                if (mTextResult.text.substring(1).contains(CHAR_MINUS)){
                                    afterValue = calcSymbolReplace(mTextResult.text.substring(1),
                                        CHAR_MINUS, CHAR_PLUS)
                                    afterValue = "-$afterValue"
                                }else{
                                    mTextResult.text = String.format("%s%s", mTextResult.text, btn.text)
                                }
                            }else{
                                when {
                                    mTextResult.text.substring(1).contains(CHAR_MINUS) -> {
                                        afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_MINUS, CHAR_PLUS)
                                    }
                                    mTextResult.text.substring(1).contains(CHAR_MULTIPLY) -> {
                                        afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_MULTIPLY, CHAR_PLUS)
                                    }
                                    mTextResult.text.substring(1).contains(CHAR_MINUS) -> {
                                        afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_DIVIDE, CHAR_PLUS)
                                    }
                                    else -> {
                                        mTextResult.text = String.format("%s%s", mTextResult.text, btn.text)
                                    }

                                }

                            }
                        }

                        mTextResult.text.contains(CHAR_MULTIPLY) -> {
                            afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_MULTIPLY, CHAR_PLUS)
                        }

                        mTextResult.text.contains(CHAR_DIVIDE) -> {
                            afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_DIVIDE, CHAR_PLUS)
                        }
                        else ->{
                            mTextResult.text = String.format("%s%s", mTextResult.text, btn.text)
                        }

                    }
                }

                R.id.btnMainasu -> {
                    if(mTextResult.text == ""){
                        return
                    }
                    when {
                        mTextResult.text.substring(1).contains(CHAR_MINUS) -> {
                            return
                        }

                        mTextResult.text.contains(CHAR_PLUS) -> {
                            afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_PLUS, CHAR_MINUS)
                        }

                        mTextResult.text.contains(CHAR_MULTIPLY) -> {
                            afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_MULTIPLY, CHAR_MINUS)
                        }

                        mTextResult.text.contains(CHAR_DIVIDE) -> {
                            afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_DIVIDE, CHAR_MINUS)
                        }
                        else ->{
                            mTextResult.text = String.format("%s%s", mTextResult.text, btn.text)
                        }

                    }
                }

                R.id.btnKakeru -> {
                    if(mTextResult.text == ""){
                        return
                    }
                    when {
                        mTextResult.text.contains(CHAR_MULTIPLY) -> {
                            return
                        }

                        mTextResult.text.contains(CHAR_PLUS) -> {
                            afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_PLUS, CHAR_MINUS)
                        }

                        mTextResult.text.contains(CHAR_MINUS) -> {
                            if(mTextResult.text.substring(0,1) == CHAR_MINUS){
                                if(mTextResult.text.substring(1).contains(CHAR_MINUS)){
                                    afterValue = calcSymbolReplace(mTextResult.text.substring(1), CHAR_MINUS, CHAR_MULTIPLY)
                                    afterValue = "-$afterValue"
                                } else {
                                    mTextResult.text = String.format("%s%s", mTextResult.text, btn.text)
                                }
                            } else {
                                afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_MINUS, CHAR_MULTIPLY)
                            }
                        }

                        mTextResult.text.contains(CHAR_DIVIDE) -> {
                            afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_DIVIDE, CHAR_MULTIPLY)
                        }
                        else ->{
                            mTextResult.text = String.format("%s%s", mTextResult.text, btn.text)
                        }
                    }
                }

                R.id.btnWaru -> {
                    if(mTextResult.text == ""){
                        return
                    }
                    when {
                        mTextResult.text.contains(CHAR_DIVIDE) -> {
                            return
                        }

                        mTextResult.text.contains(CHAR_PLUS) -> {
                            afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_PLUS, CHAR_DIVIDE)
                        }

                        mTextResult.text.contains(CHAR_MINUS) -> {
                            if(mTextResult.text.substring(0,1) == CHAR_MINUS){
                                if(mTextResult.text.substring(1).contains(CHAR_MINUS)){
                                    afterValue = calcSymbolReplace(mTextResult.text.substring(1), CHAR_MINUS, CHAR_DIVIDE)
                                    afterValue = "-$afterValue"
                                } else {
                                    mTextResult.text = String.format("%s%s", mTextResult.text, btn.text)
                                }
                            } else {
                                afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_MINUS, CHAR_DIVIDE)
                            }
                        }

                        mTextResult.text.contains(CHAR_MULTIPLY) -> {
                            afterValue = calcSymbolReplace(mTextResult.text.toString(), CHAR_MULTIPLY, CHAR_DIVIDE)
                        }
                        else ->{
                            mTextResult.text = String.format("%s%s", mTextResult.text, btn.text)
                        }
                    }
                }

            }

            if(afterValue != ""){
                mTextResult.text = afterValue
            }
        }

    }


    private fun calcSymbolReplace(replaceValue: String, oldSymbol: String, newSymbol: String): String {
        return replaceValue.replace(oldSymbol,newSymbol)
    }

    private fun executeCalc(){

        val text = mTextResult.text.toString()

        var checkValue = text
        if (mTextResult.text.substring(0, 1) == CHAR_MINUS){
            checkValue = mTextResult.text.substring(1)
        }

        val startIndex = 0

        var answer = ""

        when {
            checkValue.contains(CHAR_PLUS) -> {
                val symbolIndex = text.indexOf(CHAR_PLUS)
                val leftValue = text.substring(startIndex, symbolIndex)
                val rightValue = text.substring(symbolIndex + 1)

                answer = (leftValue.toDouble() + rightValue.toDouble()).toString()
            }

            checkValue.contains(CHAR_MINUS) -> {
                if (mTextResult.text.substring(0,1) == CHAR_MINUS) {
                    val symbolIndex = text.indexOf(CHAR_MINUS,1)
                    val leftValue = text.substring(startIndex, symbolIndex)
                    val rightValue = text.substring(symbolIndex + 1)

                    answer = (leftValue.toDouble() + rightValue.toDouble()).toString()

                } else {
                    val symbolIndex = text.indexOf(CHAR_MINUS,1)
                    val leftValue = text.substring(startIndex, symbolIndex)
                    val rightValue = text.substring(symbolIndex + 1)

                    answer = (leftValue.toDouble() - rightValue.toDouble()).toString()

                }
            }

            checkValue.contains(CHAR_MULTIPLY) -> {
                val symbolIndex = text.indexOf(CHAR_MULTIPLY)
                val leftValue = text.substring(startIndex, symbolIndex)
                val rightValue = text.substring(symbolIndex + 1)

                answer = (leftValue.toDouble() * rightValue.toDouble()).toString()
            }

            checkValue.contains(CHAR_DIVIDE) -> {
                val symbolIndex = text.indexOf(CHAR_DIVIDE)
                val leftValue = text.substring(startIndex, symbolIndex)
                val rightValue = text.substring(symbolIndex + 1)

                answer = (leftValue.toDouble() / rightValue.toDouble()).toString()
            }

            else -> {
                return
            }
        }

        answer = roundValue(answer)

        if (answer != ""){
            val regex = Regex(".0\$")
            mTextResult.text = regex.replace(answer, "")
        }

    }

    private fun roundValue(value: String) :String {
        return ((value.toDouble() * 10.0).roundToLong() / 10.0).toString()
    }
}
