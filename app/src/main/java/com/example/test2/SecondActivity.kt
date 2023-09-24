package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.test2.databinding.ActivityMainBinding
import com.example.test2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemList= listOf("one","two","three")                               //**spinner**//
        val adapter=ArrayAdapter<String>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,itemList)
        binding.spWeek.adapter=adapter


        binding.spWeek.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    this@SecondActivity,
                    "you selected ${parent?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }                                                                                        //**spinner**//
////////////////////////////////////////////////////////////////////////////////////////////
        val deleteDialog = AlertDialog.Builder(this)                      //**dialog_1**//
            .setTitle("delete").setMessage("do you want to delete this file?")
            .setIcon(R.drawable.ic_file)
            .setPositiveButton("yes") { _, _ ->

                Toast.makeText(this, "you delete this file", Toast.LENGTH_LONG).show()

            }
            .setNeutralButton("no") { _, _ ->

                Toast.makeText(this, "you do not delete this file", Toast.LENGTH_LONG).show()
            }.create()
        binding.butDialog1.setOnClickListener {
            deleteDialog.show()
        }                                                                          //**dialog_1**//
///////////////////////////////////////////////////////////////////////////////

        val option =
            arrayOf("pink", "purple", "gray")                           //**single choice dialog**//

        val colorDoalog = AlertDialog.Builder(this)
            .setTitle("color").setMessage("choose your favorit color!")
            .setSingleChoiceItems(option, 0) { dialogInterFace, i ->

                Toast.makeText(this, "you choose ${option[i]}", Toast.LENGTH_LONG).show()

            }

            .setPositiveButton("accept") { _, _ ->

                Toast.makeText(this, "you accept", Toast.LENGTH_LONG).show()
            }
            .setNeutralButton("decline") { _, _ ->

                Toast.makeText(this, "you decline", Toast.LENGTH_LONG).show()
            }

        binding.butDialog2.setOnClickListener {
            colorDoalog.show()
        }                                                                     //**single choice dialog**//
///////////////////////////////////////////////////////////////////////////////////////////////////
        val option1 =
            arrayOf("berger", "pizza", "rice", "sandwich")         //**multi choice dialog**//
        val foodDialog = AlertDialog.Builder(this)
            .setTitle("food").setMessage("choose your food!")
            .setMultiChoiceItems(
                option1,
                booleanArrayOf(false, false, false, false)
            ) { _, i, isChecked ->

                if (isChecked) {
                    Toast.makeText(this, "you choose ${option[i]}", Toast.LENGTH_LONG).show()

                } else {


                    Toast.makeText(this, "you unchoose ${option[i]}", Toast.LENGTH_LONG).show()
                }
            }

            .setPositiveButton("accept") { _, _ ->

                Toast.makeText(this, "you accept", Toast.LENGTH_LONG).show()
            }
            .setNeutralButton("decline") { _, _ ->

                Toast.makeText(this, "you decline", Toast.LENGTH_LONG).show()
            }

        binding.butDialog3.setOnClickListener {
            foodDialog.show()
        }                                                                              //**multi choice dialog**//
        //////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}