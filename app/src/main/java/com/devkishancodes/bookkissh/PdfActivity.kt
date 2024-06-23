package com.devkishancodes.bookkissh

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devkishancodes.bookkissh.databinding.ActivityPdfBinding
import com.devkishancodes.bookkissh.presentation.fragment.PdfToolsFragment
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.github.barteksc.pdfviewer.util.FitPolicy

class PdfActivity : AppCompatActivity() {
    val activity = this
    lateinit var binding: ActivityPdfBinding


    lateinit var bookPdf: String
    lateinit var bookId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfBinding.inflate(layoutInflater)
        this.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)
        supportActionBar?.hide()
        setupBasicViews()
        binding.apply {
            bookPdf = intent.getStringExtra("book_pdf").toString()
            bookId = intent.getStringExtra("book_id").toString()
   //         mBannerAd.loadBannerAd()

            pdfView.fromUri(bookPdf.toUri())
                .swipeHorizontal(true)
                .scrollHandle(DefaultScrollHandle(activity))
                .enableSwipe(true)
                .pageFling(true)
                .enableDoubletap(true)
                .pageFitPolicy(FitPolicy.BOTH)
                .fitEachPage(true)
                .pageSnap(true)
                .enableAntialiasing(true)
                .autoSpacing(true)
                .pageFling(true)
                .load()
        }

    }

    private fun setupBasicViews() {
        binding.mToolsFab.setOnClickListener {
            val toolsBottomSheet = PdfToolsFragment()
            toolsBottomSheet.show(supportFragmentManager, toolsBottomSheet.tag)
        }

    }
}

