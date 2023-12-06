package com.majedul.assignment.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.majedul.assignment.MVVMApplication
import com.majedul.assignment.data.model.Items
import com.majedul.assignment.di.component.DaggerActivityComponent
import com.majedul.assignment.di.module.ActivityModule
import com.majedul.assignment.utils.AppConstant.ITEM_VALUE
import com.majedul.mvvm.R
import com.majedul.mvvm.databinding.ActivitySearchBinding
import com.majedul.mvvm.databinding.ActivitySearchDetailsBinding
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

class SearchDetailsActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySearchDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        binding = ActivitySearchDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()

    }

    private fun setUI() {
        val jsonUserData = intent.getStringExtra(ITEM_VALUE).toString()
        Log.d("jsonUserData",jsonUserData)
        val itemData:Items? = Gson().fromJson(jsonUserData, Items::class.java)
        Log.d("itemData", itemData.toString())

        binding.repositoryName.text = itemData?.name
        binding.repositoryDescription.text = itemData?.description
        binding.fullName.text = itemData?.fullName
        val startCount = (itemData?.stargazersCount)?.div(1000)
        binding.starCount.text = "$startCount K stars"

        val forkCount = (itemData?.forksCount)?.div(1000)
        binding.forkCount.text = "$forkCount K forks"

        Glide.with(binding.repositoryImage.context)
            .load(itemData?.owner?.avatarUrl)
            .into(binding.repositoryImage)


        val issues = (itemData?.openIssuesCount)?.div(1000)
        binding.issueCount.text = "$issues K+"

        binding.engineName.text = itemData?.owner?.login

        val updateTime = itemData?.updatedAt
        val timeDifferenceMillis = System.currentTimeMillis() - SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault()).parse(updateTime).time
        val timeAgo = android.text.format.DateUtils.getRelativeTimeSpanString(System.currentTimeMillis() - timeDifferenceMillis, System.currentTimeMillis(), android.text.format.DateUtils.MINUTE_IN_MILLIS)


        binding.updateTime.text = "Updated $timeAgo "

       binding.branchName.text = itemData?.defaultBranch

        Glide.with(binding.repoIcon.context)
            .load(itemData?.owner?.avatarUrl)
            .into(binding.repoIcon)


    }

    private fun injectDependencies() {
        DaggerActivityComponent.builder()
            .applicationComponent((application as MVVMApplication).applicationComponent)
            .activityModule(ActivityModule(this)).build().inject(this)
    }
}