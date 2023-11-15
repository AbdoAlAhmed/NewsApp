package com.abdo.news.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abdo.news.databinding.FragmentArticleBinding


class ArticleFragment : Fragment() {

    private lateinit var binding: FragmentArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArticleBinding.inflate(layoutInflater, container, false)




        return binding.root
    }

}