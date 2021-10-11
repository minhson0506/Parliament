package com.example.projecttask1parliamentmemberview.screen.member

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projecttask1parliamentmemberview.data.*
import kotlinx.coroutines.launch

/**
 * Name: Son Dang (2012177)
 * Date: 10.10.2021
 * ViewModel for MemberFragment
 */

class MemberViewModel: ViewModel() {
    private val database: MemberDao = MemberDatabase.getInstance().memberDao

    private lateinit var _memberDetail: LiveData<Member>
    val memberDetail: LiveData<Member>
        get() = _memberDetail

    private lateinit var _personNumber: LiveData<Int>
    val personNumber: LiveData<Int>
        get() = _personNumber

    private lateinit var _memberRatings: LiveData<List<Double>>
    val memberRatings: LiveData<List<Double>>
        get() = _memberRatings

    private val _ratingAverage = MutableLiveData<Double>()
    val ratingAverage: LiveData<Double>
        get() = _ratingAverage

    fun getMember(personNumber: Int) {
        _memberDetail = database.getMember(personNumber)
    }

    fun insertMemberRatingAndComment(personNumber: Int, rating: Float, comment: String) {
        viewModelScope.launch {
            database.insertRating(Rate(personNumber = personNumber,rating = rating))
            if(comment.isNotEmpty()) {
                database.insertComment(Comment(personNumber = personNumber, comment = comment))
            }
        }
    }

    fun getMemberRatings(personNumber: Int) {
        _memberRatings = database.getAllRatings(personNumber)
    }

    fun getRatingAverage(memberRatings: List<Double>) {
        if(memberRatings.isNotEmpty()) {
            _ratingAverage.value = memberRatings.average()
        } else _ratingAverage.value = 0.0
    }
}