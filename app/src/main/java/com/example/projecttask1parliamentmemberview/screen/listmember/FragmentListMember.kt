package com.example.projecttask1parliamentmemberview.screen.listmember

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projecttask1parliamentmemberview.R
import com.example.projecttask1parliamentmemberview.databinding.FragmentListMemberBinding

/**
 * Name: Son Dang (2012177)
 * Date: 20.09.2021
 * Fragment for MemberList
 */

class FragmentListMember : Fragment() {

    lateinit var binding: FragmentListMemberBinding
    private lateinit var listMemberViewModel: ListMemberViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list_member,
            container,
            false)

        // Specify the fragment view as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner

        val viewModelFactory = ListMemberViewModelFactory()

        // Initialize ViewModel
        listMemberViewModel = ViewModelProvider(
            this,
            viewModelFactory).get(ListMemberViewModel::class.java)

        // Get List of members
        listMemberViewModel.getAllMembers()

        // Set Adapter for RecyclerView
        val adapter = ListMemberAdapter(MemberListener { personNumber ->
            Toast.makeText(context, "$personNumber", Toast.LENGTH_LONG).show()
            listMemberViewModel.onMemberClicked(personNumber)
        })
        binding.memberList.adapter = adapter

        // Observe any time when the List<Member> changes
        listMemberViewModel.allMembers.observe(viewLifecycleOwner,
            {
                adapter.submitList(it)
            })

        // Navigate to Fragment Member
        listMemberViewModel.navigateToMember.observe(viewLifecycleOwner,
            { personNumber -> personNumber?.let {
                this.findNavController().navigate(
                    FragmentListMemberDirections
                        .actionFragmentListMemberToFragmentMember(personNumber)
                )
                listMemberViewModel.onMemberNavigated()
            }
        })

        return binding.root
    }
}