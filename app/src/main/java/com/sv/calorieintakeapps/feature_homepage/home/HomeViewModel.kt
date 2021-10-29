//package com.sv.calorieintakeapps.feature.home.presentation.home
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.asLiveData
//import com.sv.calorieintakeapps.feature.home.domain.usecase.HomepageUseCase
//
//class HomeViewModel(private val useCase: HomepageUseCase) : ViewModel() {
//
//    val isLoggedIn = useCase.isLoggedIn().asLiveData()
//
//    val userName = useCase.getUserName().asLiveData()
//
//    fun logout() = useCase.logout()
//}