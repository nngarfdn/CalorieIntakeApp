//package com.sv.calorieintakeapps.feature_home.presentation.history
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.sv.calorieintakeapps.feature_home.databinding.FragmentHistoryBinding
//
//class HistoryFragment : Fragment() {
//
//    private lateinit var binding: FragmentHistoryBinding
//    private lateinit var pagerAdapter: HistoryPagerAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
//        pagerAdapter = context?.let { HistoryPagerAdapter(it, childFragmentManager) }!!
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupViewPager()
//    }
//
//    private fun setupViewPager() {
//        binding.viewPagerLogin.adapter = pagerAdapter
//        binding.tabLayoutRiwayat.setupWithViewPager(binding.viewPagerLogin)
//    }
//}