package com.nic.newonbackpress

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

abstract  class Activity() :AppCompatActivity() {



    fun  OnCallBackPress (enabled:Boolean)= object: OnBackPressedCallback(enabled){
    override fun handleOnBackPressed() {
      Log.e("TAG", "handleOnBackPressed: ${this}", )
      with(this){

      }


    }

}



//  val registeractivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//    with(it){
//
//      Log.e("TAG", ": ${data?.getStringExtra("name")}", )
//      if(it.resultCode == RESULT_OK){
//        var intent=it.data
//
//
//       // button.setText(intent?.getStringExtra("name"))
//      }
//
//
//    }
//  }

}