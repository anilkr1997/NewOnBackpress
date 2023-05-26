package com.nic.newonbackpress

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import com.nic.newonbackpress.databinding.ActivityMainBinding

class MainActivity() : Activity() {
lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBackPressedDispatcher.addCallback(OnCallBackPress(false))
         // supportActionBar?.apply { setDisplayHomeAsUpEnabled(true) }
       binding. buttion.setOnClickListener {
                startActivity(Intent(this@MainActivity, BottemNavigationActivity::class.java))

            }


    }

    override fun onStart() {
        Log.e("TAG", "onStart: " )


        super.onStart()
    }

    override fun onResume() {
        Log.e("TAG", "onResume: ", )

        super.onResume()
    }


}

