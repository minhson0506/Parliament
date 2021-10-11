package com.example.projecttask1parliamentmemberview.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Name: Son Dang (2012177)
 * Date: 9.10.2021
 * Create DAO class that can access the database
 */

@Dao
interface MemberDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(member: Member)

    @Query("SELECT DISTINCT party FROM member_table")
    suspend fun getAllParties(): List<String>

    @Query("SELECT * FROM member_table WHERE party = :party")
    suspend fun getMembersByParty(party: String): List<Member>

    // Use person number as the id of each member
    @Query("SELECT * FROM member_table WHERE personNumber = :personNumber")
    fun getMember(personNumber: Int): LiveData<Member>

    @Query("SELECT * FROM member_table ORDER BY first ASC")
    fun getAll(): LiveData<List<Member>>

    //insert rating to database
    @Insert
    suspend fun insertRating(rating: Rate)

    //insert comment to database
    @Insert
    suspend fun insertComment(comment: Comment)

    @Query("SELECT rating FROM rate_table WHERE personNumber = :personNumber")
    fun getAllRatings(personNumber: Int): LiveData<List<Double>>

    @Query("SELECT * FROM comment_table WHERE personNumber = :personNumber")
    fun getAllComments(personNumber: Int): LiveData<List<Comment>>
}