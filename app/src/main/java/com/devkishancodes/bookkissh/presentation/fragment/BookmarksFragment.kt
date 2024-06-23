package com.devkishancodes.bookkissh.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.devkishancodes.bookkissh.PdfActivity
import com.devkishancodes.bookkissh.core.local.AppDatabase
import com.devkishancodes.bookkissh.databinding.FragmentBookmarksBinding
import com.devkishancodes.bookkissh.presentation.adapter.BookmarksAdapter
import com.devkishancodes.bookkissh.presentation.viewmodel.ToolsViewModel
import com.devkishancodes.bookkissh.presentation.viewmodel.ToolsViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookmarksFragment : BottomSheetDialogFragment() {
    private val binding by lazy {
        FragmentBookmarksBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        val mActivity = requireActivity() as PdfActivity
        ViewModelProvider(mActivity, ToolsViewModelFactory(mActivity))[ToolsViewModel::class.java]
    }

    private val list: MutableList<Int> = mutableListOf()
    private val adapter by lazy {
        BookmarksAdapter(
            list = list,
            viewModel = viewModel,
            fragment = this,
            context = requireActivity()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            mBookmarksRv.adapter = adapter
            getData()
        }
    }

    private fun getData() {
        val mActivity = requireActivity() as PdfActivity
        val database = AppDatabase.getDatabase(requireActivity())
        CoroutineScope(Dispatchers.IO).launch {
            database?.bookmarksDao()?.getBookmarks(mActivity.bookId)?.forEach {
                list.add(it.pageNo)
            }
            mActivity.runOnUiThread {
                adapter.notifyDataSetChanged()
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root


}



















