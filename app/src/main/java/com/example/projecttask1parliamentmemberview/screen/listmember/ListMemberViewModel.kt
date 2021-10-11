package com.example.projecttask1parliamentmemberview.screen.listmember

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projecttask1parliamentmemberview.data.Member
import com.example.projecttask1parliamentmemberview.data.MemberDao
import com.example.projecttask1parliamentmemberview.data.MemberDatabase
import com.example.projecttask1parliamentmemberview.data.MemberRepository
import com.example.projecttask1parliamentmemberview.network.Api
import kotlinx.coroutines.launch

/**
 * Name: Son Dang (2012177)
 * Date: 10.10.2021
 * The ViewModel of ListMemberFragment.
 */

class ListMemberViewModel : ViewModel() {
    private val database: MemberDao = MemberDatabase.getInstance().memberDao
    private val getAllData: LiveData<List<Member>>
    private val repository: MemberRepository

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<List<Member>>()
    val response: LiveData<List<Member>>
        get() = _response

    // Get list of members from database
    private lateinit var _allMembers: LiveData<List<Member>>
    val allMembers: LiveData<List<Member>>
        get() = _allMembers

    // Navigate to member fragment
    private val _navigateToMember = MutableLiveData<Int?>()
    val navigateToMember
        get() = _navigateToMember

    init {
        repository = MemberRepository(database)
        getAllData = repository.getData
        getParliamentInfo()
    }

    // Fetch data from internet using retrofit and moshi libraries, then store data in Room
    private fun getParliamentInfo() {
        viewModelScope.launch {
            try {
                val fetchedData = Api.retrofitService.getProperties()
                _response.value = fetchedData

                //insert data to Room
                if (fetchedData.isNotEmpty()) {
                    fetchedData.forEach {
                        repository.insert(it)
                    }
                }
            } catch (e: Exception) {
                _response.value = ArrayList()
                Log.i("error", e.message.toString())
            }
        }
    }

    fun getAllMembers() {
        _allMembers = database.getAll()
    }

    fun onMemberClicked(personNumber: Int) {
        _navigateToMember.value = personNumber
    }

    fun onMemberNavigated() {
        _navigateToMember.value = null
    }
}