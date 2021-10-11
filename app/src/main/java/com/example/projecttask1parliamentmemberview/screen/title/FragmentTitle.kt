package com.example.projecttask1parliamentmemberview.screen.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.projecttask1parliamentmemberview.R
import com.example.projecttask1parliamentmemberview.databinding.FragmentTitleBinding

/**
 * Name: Son Dang (2012177)
 * Date: 20.9.2021
 * The title Fragment will be displayed when starting the App
 */

class FragmentTitle : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater,
            R.layout.fragment_title,
            container,
            false)

        binding.checkButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_fragmentTitle_to_fragmentListMember)
        }
        return binding.root
    }
}