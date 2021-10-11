package com.example.projecttask1parliamentmemberview.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
* Name: Son Dang (2012177)
* Date: 10.10.2021
* Create Rate table
*/

@Entity(tableName = "rate_table")
data class Rate(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "personNumber")
    val personNumber: Int,

    @ColumnInfo(name = "rating")
    val rating: Float
)
