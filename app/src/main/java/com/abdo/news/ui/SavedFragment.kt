package com.abdo.news.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abdo.news.databinding.FragmentSavedBinding
import com.abdo.news.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class SavedFragment : Fragment() {
    private val newsViewModel by viewModel<NewsViewModel>()
    private lateinit var binding: FragmentSavedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSavedBinding.inflate(layoutInflater, container, false)
        binding.newsViewModel = newsViewModel
        binding.lifecycleOwner = this

        return binding.root
    }


}