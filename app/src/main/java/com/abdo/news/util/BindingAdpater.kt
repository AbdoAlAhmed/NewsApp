package com.abdo.news.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abdo.news.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException


@BindingAdapter("imageUrl")
fun imageFromUrl(imageView: ImageView, url: String? = null) {
    try {
        Glide.with(imageView.context).load(url!!).placeholder(R.drawable.ic_news).into(imageView)
    } catch (e: GlideException) {
        Log.d("imageFromUrl", "imageFromUrl: $e")
    } catch (e: Exception) {
        Log.d("imageFromUrl", "imageFromUrl: $e")
    }
}

@BindingAdapter("bindList")
fun bindList(recyclerView: RecyclerView, list: List<*>) {
    var adapter = recyclerView.adapter as ListAdapter<*, *>
    adapter.submitList(list as List<Nothing>)
}