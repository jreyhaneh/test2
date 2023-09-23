package com.example.test2

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
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

//        binding.butImage.setOnClickListener {                           //show image
//
//            Intent(Intent.ACTION_GET_CONTENT).also {
//                it.type="image/*"
//                startActivityForResult(it,0)
//            }
//        }
//    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode==Activity.RESULT_OK && requestCode==0){
//            val uri=data?.data
//            binding.ImView.setImageURI(uri)
//    }

        binding.butPermission.setOnClickListener {
            requestPermission()
        }


    }

    private fun hasWriteExternalStoragePermission() =
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU){
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        }else true

    private fun hasAccessBackgroundLocationPermission() =
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED

    private fun hasAccessCoarseLocationPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    private fun requestPermission() {
        val permissionList = mutableListOf<String>()


        if (!hasWriteExternalStoragePermission()) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!hasAccessBackgroundLocationPermission()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
        if (!hasAccessCoarseLocationPermission()) {
            permissionList.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        if (permissionList.isNotEmpty()) {
            Log.e("Log__", "list: $permissionList")
            ActivityCompat.requestPermissions(this, permissionList.toTypedArray(), 1000)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1000 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices)
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("permissions request", "$permissions")
                }
        }


    }
}
