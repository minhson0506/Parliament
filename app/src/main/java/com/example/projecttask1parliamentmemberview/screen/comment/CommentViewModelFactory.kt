package com.example.projecttask1parliamentmemberview.screen.comment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
* Name: Son Dang (2012177)
* Date: 11.10.2021
* ViewModel Factory for Comment ViewModel
*/

class CommentViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CommentViewModel::class.java)) {
            return CommentViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}