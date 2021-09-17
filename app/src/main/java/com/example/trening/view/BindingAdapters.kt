package com.example.trening.view

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.trening.Country

@BindingAdapter("app:visibleIfTrue")
fun visibleIfTrue(view: View, value: Boolean){
    view.visibility = if (value == true)
        View.VISIBLE
    else
        View.INVISIBLE
}

/*
@BindingAdapter("app:list")
fun visibleIfTrue(recyclerView: RecyclerView, value: List<Country>){
    val adapter = CountriesAdapter(value)
    recyclerView.adapter = adapter
}*/
