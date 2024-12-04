/**
 * Credit to Jeroen Mols
 * https://jeroenmols.com/blog/2019/04/02/modularizationexample/
 * */

package com.sv.calorieintakeapps.library_common.action

import android.content.Context
import android.content.Intent
import com.sv.calorieintakeapps.app.splash.TutorialActivity
import com.sv.calorieintakeapps.feature_add_new_food.AddNewFoodActivity
import com.sv.calorieintakeapps.feature_auth.presentation.login.LoginActivity
import com.sv.calorieintakeapps.feature_auth.presentation.register.RegisterActivity
import com.sv.calorieintakeapps.feature_fooddetails.presentation.FoodDetailActivity
import com.sv.calorieintakeapps.feature_foodnutrition.data.OnClickItemMode
import com.sv.calorieintakeapps.feature_foodnutrition.presentation.details.FoodNutritionDetailsActivity
import com.sv.calorieintakeapps.feature_foodnutrition.presentation.search.FoodNutritionSearchActivity
import com.sv.calorieintakeapps.feature_homepage.presentation.HomepageActivity
import com.sv.calorieintakeapps.feature_macronutrientintake.presentation.input.MacronutrientIntakeInputActivity
import com.sv.calorieintakeapps.feature_macronutrientintake.presentation.results.MacronutrientIntakeResultsActivity
import com.sv.calorieintakeapps.feature_merchantlist.presentation.MerchantsActivity
import com.sv.calorieintakeapps.feature_merchantmenu.presentation.MerchantMenuActivity
import com.sv.calorieintakeapps.feature_profile.presentation.ProfileActivity
import com.sv.calorieintakeapps.feature_reportdetails.presentation.ReportDetailsActivity
import com.sv.calorieintakeapps.feature_reporting.presentation.ReportingActivity
import com.sv.calorieintakeapps.feature_reporting.presentation.UrtFoodSearchActivity
import com.sv.calorieintakeapps.feature_scanner.presentation.ScanActivity

object Actions {
    
    const val EXTRA_DATE = "extra_date"
    const val EXTRA_FOOD_ID = "extra_food_id"
    const val EXTRA_FOOD_NAME = "extra_food_name"
    const val EXTRA_FOOD_IMAGE = "extra_food_image"
    const val EXTRA_FOOD_LABEL = "extra_food_label"
    const val EXTRA_MERCHANT_ID = "extra_merchant_id"
    const val EXTRA_MERCHANT_NAME = "extra_merchant_name"
    const val EXTRA_NILAIGIZI_COM_FOOD_ID = "extra_nilai_gizi_com_food_id"
    const val EXTRA_REPORT_ID = "extra_report_id"
    const val EXTRA_EXPECT_SEARCH = "extra_expect_search"
    const val EXTRA_WRITE_FOOD_NAME = "extra_write_food_name"
    const val EXTRA_ON_CLICK_ITEM_MODE = "extra_on_click_item_mode"
    const val EXTRA_IS_CLICK_ENABLED = "extra_is_click_enabled"
    const val EXTRA_IS_FROM_LOCAL_DB = "extra_is_from_local_db"

    const val EXTRA_NILAIGIZI_COM_PROTEIN = "extra_nilaigizi_com_protein" // 1
    const val EXTRA_NILAIGIZI_COM_CARBS = "extra_nilaigizi_com_carbs" // 2
    const val EXTRA_NILAIGIZI_COM_CALORIES = "extra_nilaigizi_com_calories" // 3
    const val EXTRA_NILAIGIZI_COM_FAT = "extra_nilaigizi_com_fat" // 4
    const val EXTRA_NILAIGIZI_COM_AIR = "extra_nilaigizi_com_air" // 4

    const val EXTRA_URT_LIST = "extra_urt_list"
    
    fun Context?.openFoodDetailsIntent(
        merchantName: String,
        foodId: Int,
        foodName: String,
        foodImage: String,
        foodLabel: String,
    ): Intent {
        return Intent(this?.applicationContext, FoodDetailActivity::class.java)
            .putExtra(EXTRA_MERCHANT_NAME, merchantName)
            .putExtra(EXTRA_FOOD_ID, foodId)
            .putExtra(EXTRA_FOOD_NAME, foodName)
            .putExtra(EXTRA_FOOD_IMAGE, foodImage)
            .putExtra(EXTRA_FOOD_LABEL, foodLabel)
    }
    
    fun Context?.openFoodNutritionDetailsIntent(
        foodId: Int,
        merchantId: Int?,
    ): Intent {
        return Intent(this?.applicationContext, FoodNutritionDetailsActivity::class.java)
            .putExtra(EXTRA_FOOD_ID, foodId)
            .putExtra(EXTRA_MERCHANT_ID, merchantId)
    }
    
    fun Context?.openFoodNutritionSearchIntent(
        merchantId: Int?,
        onClickItemMode: OnClickItemMode = OnClickItemMode.OPEN_DETAIL
    ): Intent {
        return Intent(this?.applicationContext, FoodNutritionSearchActivity::class.java)
            .putExtra(EXTRA_MERCHANT_ID, merchantId)
            .putExtra(EXTRA_ON_CLICK_ITEM_MODE, onClickItemMode.name)
    }

    fun Context?.openTutorialIntent(): Intent {
        return Intent(this?.applicationContext, TutorialActivity::class.java)
    }

    fun Context?.openUrtFoodSearchIntent(
        isItemClickEnabled: Boolean
    ): Intent {
        return Intent(this?.applicationContext, UrtFoodSearchActivity::class.java)
            .putExtra(EXTRA_IS_CLICK_ENABLED, isItemClickEnabled)
    }
    
    fun Context?.openHomepageIntent(): Intent {
        return Intent(this?.applicationContext, HomepageActivity::class.java)
    }
    
    fun Context?.openLoginIntent(): Intent {
        return Intent(this?.applicationContext, LoginActivity::class.java)
    }
    
    fun Context?.openMacronutrientIntakeInput(): Intent {
        return Intent(this?.applicationContext, MacronutrientIntakeInputActivity::class.java)
    }
    
    fun Context?.openMacronutrientIntakeResults(
        date: String,
    ): Intent {
        return Intent(this?.applicationContext, MacronutrientIntakeResultsActivity::class.java)
            .putExtra(EXTRA_DATE, date)
    }
    
    fun Context?.openMerchantListIntent(): Intent {
        return Intent(this?.applicationContext, MerchantsActivity::class.java)
    }
    
    fun Context?.openMerchantMenuIntent(merchantId: Int): Intent {
        return Intent(this?.applicationContext, MerchantMenuActivity::class.java)
            .putExtra(EXTRA_MERCHANT_ID, merchantId)
    }
    
    fun Context?.openProfileIntent(): Intent {
        return Intent(this?.applicationContext, ProfileActivity::class.java)
    }
    
    fun Context?.openRegisterIntent(): Intent {
        return Intent(this?.applicationContext, RegisterActivity::class.java)
    }

    fun Context?.openAddNewFoodIntent(): Intent {
        return Intent(this?.applicationContext, AddNewFoodActivity::class.java)
    }
    
    fun Context?.openReportingIntent(
        foodId: Int? = null,
        foodName: String? = null,
        merchantId: Int? = null,
        nilaigiziComFoodId: Int? = null,
        calories: String? = null,
        protein: String? = null,
        fat: String? = null,
        carbs: String? = null,
        expectSearch: Boolean = false,
        writeFoodName: Boolean = false
    ): Intent {
        return Intent(this?.applicationContext, ReportingActivity::class.java)
            .putExtra(EXTRA_FOOD_ID, foodId)
            .putExtra(EXTRA_FOOD_NAME, foodName)
            .putExtra(EXTRA_MERCHANT_ID, merchantId)
            .putExtra(EXTRA_NILAIGIZI_COM_FOOD_ID, nilaigiziComFoodId)
            .putExtra(EXTRA_NILAIGIZI_COM_CALORIES, calories)
            .putExtra(EXTRA_NILAIGIZI_COM_PROTEIN, protein)
            .putExtra(EXTRA_NILAIGIZI_COM_FAT, fat)
            .putExtra(EXTRA_NILAIGIZI_COM_CARBS, carbs)
            .putExtra(EXTRA_EXPECT_SEARCH, expectSearch)
            .putExtra(EXTRA_EXPECT_SEARCH, expectSearch)
    }
    
    fun Context?.openReportEditingIntent(
        reportId: Int,
        foodName: String,
        isFromLocalDb: Boolean = false,
        calories: String? = null,
        protein: String? = null,
        fat: String? = null,
        carbs: String? = null,
        air: String? = null,
    ): Intent {
        return Intent(this?.applicationContext, ReportingActivity::class.java)
            .putExtra(EXTRA_REPORT_ID, reportId)
            .putExtra(EXTRA_FOOD_NAME, foodName)
            .putExtra(EXTRA_IS_FROM_LOCAL_DB, isFromLocalDb)
            .putExtra(EXTRA_NILAIGIZI_COM_CALORIES, calories)
            .putExtra(EXTRA_NILAIGIZI_COM_PROTEIN, protein)
            .putExtra(EXTRA_NILAIGIZI_COM_FAT, fat)
            .putExtra(EXTRA_NILAIGIZI_COM_CARBS, carbs)
            .putExtra(EXTRA_NILAIGIZI_COM_AIR, air)
    }
    
    fun Context?.openReportDetailsIntent(reportId: Int, foodName: String, isFromLocalDb: Boolean = false): Intent {
        return Intent(this?.applicationContext, ReportDetailsActivity::class.java)
            .putExtra(EXTRA_REPORT_ID, reportId)
            .putExtra(EXTRA_FOOD_NAME, foodName)
            .putExtra(EXTRA_IS_FROM_LOCAL_DB, isFromLocalDb)
    }
    
    fun Context?.openScannerIntent(): Intent {
        return Intent(this?.applicationContext, ScanActivity::class.java)
    }
    
}