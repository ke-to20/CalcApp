package jp.techacademy.keito.nagata.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log
import kotlinx.android.synthetic.main.activity_answer.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }

    override fun onClick(v: View) {


        //    計算結果

        var answer: Double = 0.0

        try {

            val num1: Double = editText1.text.toString().toDouble()
            val num2: Double = editText2.text.toString().toDouble()

            if (v.id == R.id.button1) {
                //        足し算
                answer = num1 + num2

            } else if (v.id == R.id.button2) {
                //        引き算
                answer = editText1.text.toString().toDouble() - editText2.text.toString().toDouble()

            } else if (v.id == R.id.button3) {
                //        掛け算
                answer = editText1.text.toString().toDouble() * editText2.text.toString().toDouble()

            } else if (v.id == R.id.button4) {
                //        割り算
                answer = editText1.text.toString().toDouble() / editText2.text.toString().toDouble()

            }

            val intent = Intent(this, Answer::class.java)
            intent.putExtra("VALUE1", answer.toString())
            Log.d("kotlintest", answer.toString())
            startActivity(intent)

        } catch (e: Exception) {
            val answer: String = "数値を入力してください"
            val intent = Intent(this, Answer::class.java)
            intent.putExtra("VALUE1", answer.toString())
            Log.d("kotlintest", answer.toString())
            startActivity(intent)

        } finally {
//            Log.d("kotlintest", "finally" + answer  )
        }

    }

}