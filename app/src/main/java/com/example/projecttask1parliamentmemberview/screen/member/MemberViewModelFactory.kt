package com.example.projecttask1parliamentmemberview.screen.member

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Name: Son Dang (2012177)
 * Date: 10.10.2021
 * ViewModel Factory for creating Member View Model
 */

class MemberViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemberViewModel()::class.java)) {
            return MemberViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}