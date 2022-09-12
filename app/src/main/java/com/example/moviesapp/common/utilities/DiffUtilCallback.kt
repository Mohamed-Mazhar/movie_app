package com.example.moviesapp.common.utilities

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

internal class AsyncDiffUtilCallback<ITEM : Any> : DiffUtil.ItemCallback<ITEM>() {

    override fun areItemsTheSame(oldItem: ITEM, newItem: ITEM) = oldItem == newItem

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ITEM, newItem: ITEM) = oldItem == newItem
}
