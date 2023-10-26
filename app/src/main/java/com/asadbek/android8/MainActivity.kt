package com.asadbek.android8

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.util.Log
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.asadbek.android8.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton

const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var editText: EditText
    lateinit var textView: TextView
    lateinit var listSavvolar:ArrayList<Savol>
    var navbat = 0
    var javoblar = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listSavvolar = ArrayList()
        button = findViewById(R.id.btn)
        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textViewSavol)

        listSavvolar.add(Savol("10 + 10","20"))
        listSavvolar.add(Savol("17 + 3","20"))
        listSavvolar.add(Savol("9 + 3","12"))
        listSavvolar.add(Savol("2023 - 2001","22"))
        listSavvolar.add(Savol("20 / 2","10"))

        textView.text = listSavvolar[navbat].savol

        button.setOnClickListener {
           if(navbat != listSavvolar.size){
               getTxt(editText.text.toString())
           }
        }



    }
    fun getTxt(javob:String){
        if (javob == listSavvolar[navbat].javob){
            navbat++
            javoblar++
            textView.text = listSavvolar[navbat].savol
            Toast.makeText(this, "Tog`ri!", Toast.LENGTH_SHORT).show()
            val vibration:Vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibration.vibrate(300)
        }else{
            navbat++
            textView.text = listSavvolar[navbat].savol
        }
    }
}