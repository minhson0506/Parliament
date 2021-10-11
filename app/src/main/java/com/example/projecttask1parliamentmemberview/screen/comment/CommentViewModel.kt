package com.example.projecttask1parliamentmemberview.screen.comment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.projecttask1parliamentmemberview.data.Comment
import com.example.projecttask1parliamentmemberview.data.MemberDao
import com.example.projecttask1parliamentmemberview.data.MemberDatabase

/**
 * Name: Son Dang (2012177)
 * Date: 11.10.2021
 * View Model for Comment Fragment
 */

class CommentViewModel : ViewModel() {
    private val database: MemberDao = MemberDatabase.getInstance().memberDao

    private lateinit var _memberComments: LiveData<List<Comment>>

    val memberComments: LiveData<List<Comment>>
        get() = _memberComments

    fun getMemberComments(personNumber: Int) {
        _memberComments = database.getAllComments(personNumber)
    }

}