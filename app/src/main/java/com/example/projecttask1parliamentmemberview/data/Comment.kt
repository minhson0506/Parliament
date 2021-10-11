package com.example.projecttask1parliamentmemberview.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Name: Son Dang (2012177)
 * Date: 10.10.2021
 * Create comment table
 */

@Entity(tableName = "comment_table")
data class Comment(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "personNumber")
    val personNumber: Int,

    @ColumnInfo(name = "comment")
    val comment: String
)
