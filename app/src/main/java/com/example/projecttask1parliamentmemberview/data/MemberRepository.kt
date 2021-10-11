package com.example.projecttask1parliamentmemberview.data

import androidx.lifecycle.LiveData

class MemberRepository (private val memberDao: MemberDao){
    val getData: LiveData<List<Member>> = memberDao.getAll()

    suspend fun insert(member: Member) {
        memberDao.insert(member)
    }
}