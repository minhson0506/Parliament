package com.example.projecttask1parliamentmemberview.workmanager

import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.projecttask1parliamentmemberview.MyApp
import com.example.projecttask1parliamentmemberview.data.MemberDatabase.Companion.getInstance
import com.example.projecttask1parliamentmemberview.data.MemberRepository
import retrofit2.HttpException
import timber.log.Timber

/**
 * Name: Son Dang (2012177)
 * Date: 11.10.2021
 * Work Manager
 */

class RefreshDataWorker (params: WorkerParameters) : CoroutineWorker(MyApp.appContext, params){
    companion object {
        const val WORK_NAME = "com.example.projecttask1parliamentmemberview.workmanager.RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        val database = getInstance().memberDao
        val repository = MemberRepository(database)

        try {
            repository.refreshMember()
            Timber.d("WorkManager: Work request for sync is run")
        } catch (e: HttpException) {
            return Result.retry()
        }
        return Result.success()
    }
}