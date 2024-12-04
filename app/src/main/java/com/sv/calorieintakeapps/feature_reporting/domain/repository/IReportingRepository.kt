package com.sv.calorieintakeapps.feature_reporting.domain.repository

import com.sv.calorieintakeapps.library_database.domain.model.Report
import com.sv.calorieintakeapps.library_database.vo.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface IReportingRepository {
    
    fun addReport(
        foodId: Int?,
        date: String,
        time: String,
        percentage: Int?,
        mood: String,
        preImageFile: File?,
        postImageFile: File?,
        nilaigiziComFoodId: Int?,
        portionCount: Float?,
        foodName: String,
        portionSize: String?,
        merchantId: Int?,
        calories: String?,
        protein: String?,
        fat: String?,
        carbs: String?,
        gramTotalDikonsumsi: Float,
        isUsingUrt: Boolean,
        gramPerUrt: Float,
        porsiUrt: Int,
    ): Flow<Resource<Boolean>>
    
    fun getReportById(reportId: Int): Flow<Resource<Report>>
    
    fun editReportById(
        reportId: Int,
        date: String,
        time: String,
        percentage: Int?,
        mood: String,
        preImageFile: File?,
        postImageFile: File?,
        foodId: Int?,
        nilaigiziComFoodId: Int?,
        portionCount: Float?,
    ): Flow<Resource<Boolean>>
    
    fun deleteReportById(reportId: Int): Flow<Resource<Boolean>>

    suspend fun addReportToDb(
        foodId: Int?,
        date: String,
        time: String,
        percentage: Int?,
        mood: String,
        preImageFile: File?,
        postImageFile: File?,
        nilaigiziComFoodId: Int?,
        portionCount: Float?,
        foodName: String,
        portionSize: String?,
        merchantId: Int?,
        calories: String?,
        protein: String?,
        fat: String?,
        carbs: String?
    ): Flow<Resource<Boolean>>

    suspend fun getReportByIdFromLocalDb(reportId: Int): Flow<Resource<Report>>

    suspend fun editReportToDb(
        roomId: Int,
        foodId: Int?,
        date: String,
        time: String,
        percentage: Int?,
        mood: String,
        preImageFile: File?,
        postImageFile: File?,
        nilaigiziComFoodId: Int?,
        portionCount: Float?,
        foodName: String,
        portionSize: String?,
        calories: String?,
        protein: String?,
        fat: String?,
        carbs: String?
    ): Flow<Resource<Boolean>>

    suspend fun deleteReportByIdFromLocal(reportId: Int): Flow<Resource<Boolean>>
}