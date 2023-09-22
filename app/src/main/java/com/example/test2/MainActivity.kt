package com.example.test2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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


//        add.setOnClickListener {

//            val firstNumber = binding.etFirt.text.toString().toInt()
//            val secondNumber = binding.etSecond.text.toString().toInt()
//            val add = firstNumber + secondNumber
//          show.setText("$add")
//            show.text = add.toString()                                    //num_1+num_2
//            imgView.setImageResource(R.drawable.ic_launcher_background)  //if set button set image in imageview
//        }

        binding.butImage.setOnClickListener {

            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type="image/*"
                startActivityForResult(it,0)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode==Activity.RESULT_OK && requestCode==0){
            val uri=data?.data
            binding.ImView.setImageURI(uri)
    }}
}