package com.nic.newonbackpress.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.navArgument

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {

navArgument("amount") {
    with(this) {
value=this.defaultValue.toString()
    }
}

        //value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

}