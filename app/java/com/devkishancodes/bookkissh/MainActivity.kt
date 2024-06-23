package com.devkishancodes.bookkissh

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.devkishancodes.bookkissh.databinding.ActivityMainBinding
import com.devkishancodes.bookkissh.domain.models.BooksModel
import com.devkishancodes.bookkissh.domain.models.HomeModel
import com.devkishancodes.bookkissh.domain.repo.MainRepo
import com.devkishancodes.bookkissh.presentation.adapter.HomeAdapter
import com.devkishancodes.bookkissh.presentation.adapter.LAYOUT_BOD
import com.devkishancodes.bookkissh.presentation.viewmodel.viewmodel.MainViewModel
import com.devkishancodes.bookkissh.presentation.viewmodel.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val activity = this
    val list: ArrayList<HomeModel> = ArrayList()
    val adapter = HomeAdapter(list, activity)
        private val TAG = "MainActivity"
    private val repo = MainRepo(activity)
    private val viewModel by lazy {
        ViewModelProvider(activity, MainViewModelFactory(repo))[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.apply {
            mRvHome.adapter = adapter
            val templist = ArrayList<BooksModel>()
            val tempModel = BooksModel(
                image = "https://i.pinimg.com/564x/98/b7/77/98b7773682e9f31537d4ace42f4c7fef.jpg",
                description = "uyiipopoipippo",
                title = "Rich Dad Poor Dad",
                author = "Dev Kishan",
                bookPDF = "fw"
            )
            for (i in 1..5) {
                templist.add(tempModel)
            }
            list.add(
                HomeModel(
                    catTitle = null,
                    booksList = null,
                    bod = tempModel,
                    LAYOUT_TYPE = LAYOUT_BOD
                )
            )

            list.add(
                HomeModel(
                    catTitle = "Self Improvements",
                    booksList = templist
                )
            )
            list.add(
                HomeModel(
                    catTitle = "Relegious Books",
                    booksList = templist
                )
            )
        }
    }
}
  /*lateinit var binding: ActivityMainBinding
    val activity = this
    val list: ArrayList<HomeModel> = ArrayList()
    val adapter = HomeAdapter(list, activity)
    private val TAG = "MainActivity"
    private val repo = MainRepo(activity)
    private val viewModel by lazy {
        ViewModelProvider(activity, MainViewModelFactory(repo))[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
          *//*  mBannerAd.loadBannerAd()*//*
            mRvHome.adapter = adapter
            SpringScrollHelper().attachToRecyclerView(mRvHome)
            viewModel.getHomeData()
            handleHomeBackend()

            mErrorLayout.mTryAgainBtn.setOnClickListener {
                viewModel.getHomeData()
            }

        }

    }

    private fun handleHomeBackend() {
        viewModel.homeLiveData.observe(activity) {
            when (it) {
                is MyResponses.Error -> {
                    Log.i(TAG, "handleHomeBackend: ${it.errorMessage}")
                   *//* binding.mErrorHolder.showWithAnim()
                    binding.mLoaderHolder.removeWithAnim()*//*
                }

                is MyResponses.Loading -> {
                    Log.i(TAG, "handleHomeBackend: Loading...")
                   *//* binding.mErrorHolder.removeWithAnim()
                    binding.mLoaderHolder.showWithAnim()*//*
                }

                is MyResponses.Success -> {
                  *//*  binding.mErrorHolder.removeWithAnim()
                    binding.mLoaderHolder.removeWithAnim()*//*
                    val tempList = it.data
                    list.clear()
                    Log.i(TAG, "handleHomeBackend: Success Called $tempList ")
                    tempList?.forEach {
                        list.add(it)

                    }
                    adapter.notifyDataSetChanged()
                }
            }

        }
    }

}
*/