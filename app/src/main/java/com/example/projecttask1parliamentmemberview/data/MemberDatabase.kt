package com.example.projecttask1parliamentmemberview.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projecttask1parliamentmemberview.MyApp

/**
 * Name: Son Dang (2012177)
 * Date: 9.10.2021
 * A database that stores Member information.
 **/

@Database(
    entities = [Member::class, Rate::class, Comment::class],
    version = 1,
    exportSchema = false
)
abstract class MemberDatabase: RoomDatabase() {
    abstract val memberDao: MemberDao

    companion object {
        @Volatile
        private var INSTANCE: MemberDatabase? = null
        fun getInstance(): MemberDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        MyApp.appContext,
                        MemberDatabase::class.java,
                        "member_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}