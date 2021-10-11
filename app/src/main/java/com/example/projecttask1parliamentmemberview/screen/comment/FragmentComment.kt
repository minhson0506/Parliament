package com.example.projecttask1parliamentmemberview.screen.comment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.projecttask1parliamentmemberview.R
import com.example.projecttask1parliamentmemberview.databinding.FragmentCommentBinding
import com.example.projecttask1parliamentmemberview.screen.member.FragmentParliamentArgs

/**
 * Name: Son Dang (2012177)
 * Date: 11.10.2021
 * Fragment for displaying Comments
 */

class FragmentComment : Fragment() {

    private lateinit var binding: FragmentCommentBinding
    private lateinit var commentListViewModel: CommentViewModel
    private val args: FragmentParliamentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_comment, container, false)

        // Get argument for destination
        val personNumber = args.personNumber

        // Initialize ViewModel
        commentListViewModel = ViewModelProvider(this, CommentViewModelFactory())
            .get(CommentViewModel::class.java)

        // Get member comments
        commentListViewModel.getMemberComments(personNumber)

        // Set adapter for the view
        val adapter = CommentAdapter()
        binding.commentList.adapter = adapter

        //Observe any time when the List<Comment> changes
        commentListViewModel.memberComments.observe(viewLifecycleOwner,
            {
                adapter.submitList(it)
            })

        return binding.root
   }
}