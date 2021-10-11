package com.example.projecttask1parliamentmemberview.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Name: Son Dang (2012177)
 * Date: 9.10.2021
 * Create Member table
 */

@Entity(tableName = "member_table")
data class Member(

    @PrimaryKey
    val personNumber: Int,

    val seatNumber: Int,

    val last: String,

    val first: String,

    val party: String,

    val minister: Boolean,

    val picture: String,

    val twitter: String?,

    val bornYear: String,

    val constituency: String
)
