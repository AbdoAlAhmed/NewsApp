package com.abdo.news.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdo.news.databinding.FragmentNewsBinding
import com.abdo.news.util.Resource
import com.abdo.news.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HeadLinesFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private val newsViewModel by viewModel<NewsViewModel>()
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(layoutInflater, container, false)
        binding.newsViewModel = newsViewModel
        binding.lifecycleOwner = this
        setupRecycler()
        newsViewModel.listOFNews.observe(viewLifecycleOwner){ resopnse ->
            when(resopnse){
                is Resource.Success -> {
                    hideProgress()
                    resopnse.data.let {
                        newsAdapter.submitList(it!!.articles)
                    }
                }
                is Resource.Error -> {
                    Toast.makeText(context, resopnse.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    showProgress()
                }
                else -> {}
            }
        }

        return binding.root
    }

    private fun showProgress() {
        binding.progressCircular.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        binding.progressCircular.visibility = View.INVISIBLE
    }

    private fun setupRecycler() {
        newsAdapter = NewsAdapter()
        binding.rvNews.apply {
            adapter =  newsAdapter
        }
    }

}