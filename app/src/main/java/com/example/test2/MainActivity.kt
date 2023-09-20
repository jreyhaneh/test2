package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val show = binding.textView
        val add = binding.button
        val imgView = binding.ImView
        add.setOnClickListener {
            val firstNumber = binding.etFirt.text.toString().toInt()
            val secondNumber = binding.etSecond.text.toString().toInt()
            val add = firstNumber + secondNumber
//          show.setText("$add")
            show.text = add.toString()

//            imgView.setImageResource(R.drawable.ic_launcher_background) //if set button set image in imageview
        }


    }
}