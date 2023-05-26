package com.nic.newonbackpress.ui.home

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.window.OnBackInvokedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nic.newonbackpress.BaseFragment
import com.nic.newonbackpress.R
import com.nic.newonbackpress.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment() {

private var _binding: FragmentHomeBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

    _binding = FragmentHomeBinding.inflate(inflater, container, false)

      requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,OnCallBackPress(false))

      val root: View = binding.root

    val textView: TextView = binding.textHome

    homeViewModel.text.observe(viewLifecycleOwner) {
      textView.text = it
    }


    return root
  }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireActivity().onBackInvokedDispatcher.registerOnBackInvokedCallback(0, OnBackInvokedCallback {



                requireActivity().onBackPressedDispatcher.onBackPressed()
            })
        }

    }
override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}