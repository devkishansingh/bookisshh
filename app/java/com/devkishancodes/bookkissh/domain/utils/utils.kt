package com.devkishancodes.bookkissh.domain.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade

fun ImageView.loadOnline(imageUrl:String){
    Glide.with(this.context)
        .load(imageUrl)
        .transition(withCrossFade())
        .into(this)
}