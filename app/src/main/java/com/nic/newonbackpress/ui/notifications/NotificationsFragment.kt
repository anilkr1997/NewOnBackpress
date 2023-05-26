package com.nic.newonbackpress.ui.notifications

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.window.OnBackInvokedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nic.newonbackpress.BaseFragment
import com.nic.newonbackpress.R
import com.nic.newonbackpress.databinding.FragmentNotificationsBinding

class NotificationsFragment : BaseFragment() {

private var _binding: FragmentNotificationsBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

    _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
    val root: View = binding.root

      requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,OnCallBackPress(true))



    val textView: TextView = binding.textNotifications
    notificationsViewModel.text.observe(viewLifecycleOwner) {
      textView.text = it
    }
    return root
  }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireActivity().onBackInvokedDispatcher.registerOnBackInvokedCallback(0, OnBackInvokedCallback {

                Log.e("TAG", "onViewCreated: ")
                val bundle = Bundle()
                bundle.putString("amount", "Anil kumar")
                findNavController().navigate(R.id.action_navigation_notifications_to_navigation_home,bundle)


                requireActivity().onBackPressedDispatcher.onBackPressed()
            })
        }

    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}