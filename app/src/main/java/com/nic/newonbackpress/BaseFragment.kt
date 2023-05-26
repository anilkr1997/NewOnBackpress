package com.nic.newonbackpress

import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(){

    fun  OnCallBackPress (enabled:Boolean)= object: OnBackPressedCallback(enabled){
        override fun handleOnBackPressed() {
            Log.e("TAG", "handleOnBackPressed: ${this}", )
            with(this){

            }


        }

    }

}