package com.majedul.assignment.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.majedul.mvvm.R
import com.majedul.mvvm.databinding.ActivitySearchBinding

import javax.inject.Inject

class SearchActivity : AppCompatActivity() {

    @Inject
    lateinit var searchViewModel: SearchViewModel

    @Inject
    lateinit var adapter: SearchAdapter

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_search)
    }



}
