package com.example.projecttask1parliamentmemberview.data

import androidx.lifecycle.LiveData
import com.example.projecttask1parliamentmemberview.network.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Name: Son Dang (2012177)
 * Date: 11.10.2021
 * Repository
 */

class MemberRepository (private val memberDao: MemberDao){
    val getData: LiveData<List<Member>> = memberDao.getAll()

    suspend fun insert(member: Member) {
        memberDao.insert(member)
    }

    suspend fun refreshMember() {
        withContext(Dispatchers.IO) {
            Timber.d("refresh data is called")
            val listMember = Api.retrofitService.getProperties()
            listMember.forEach{
                memberDao.insert(it)
            }
        }
    }
}