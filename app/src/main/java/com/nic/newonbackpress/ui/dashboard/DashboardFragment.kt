package com.nic.newonbackpress.ui.dashboard

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
import com.nic.newonbackpress.databinding.FragmentDashboardBinding

class DashboardFragment : BaseFragment() {

private var _binding: FragmentDashboardBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

    _binding = FragmentDashboardBinding.inflate(inflater, container, false)
    val root: View = binding.root

      requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,OnCallBackPress(true))


    val textView: TextView = binding.textDashboard
    dashboardViewModel.text.observe(viewLifecycleOwner) {
      textView.text = it
    }
    return root
  }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireActivity().onBackInvokedDispatcher.registerOnBackInvokedCallback(0, OnBackInvokedCallback {

                Log.e("TAG", "onViewCreated: ", )

                findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_notifications)


                requireActivity().onBackPressedDispatcher.onBackPressed()
            })
        }

    }
override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}