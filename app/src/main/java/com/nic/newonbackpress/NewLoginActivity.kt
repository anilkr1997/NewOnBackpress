package com.nic.newonbackpress

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.window.OnBackInvokedCallback
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.LifecycleOwner
import com.nic.newonbackpress.databinding.ActivityNewLoginBinding

class NewLoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityNewLoginBinding.inflate(layoutInflater).root)

       onBackPressedDispatcher.addCallback(OnCallBackPress(false))



        var intent = Intent()
        intent.putExtra("name","welcome to Back Activity in android")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            onBackInvokedDispatcher.registerOnBackInvokedCallback(1, OnBackInvokedCallback {


                onBackPressedDispatcher.onBackPressed()

            })
        }





    }



}