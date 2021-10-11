package com.example.projecttask1parliamentmemberview.screen.listmember

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Name: Son Dang (2012177)
 * Date: 10.10.2021
 * The ViewModel Factory for creating List Member ViewModel
 */

class ListMemberViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListMemberViewModel::class.java)) {
            return ListMemberViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}