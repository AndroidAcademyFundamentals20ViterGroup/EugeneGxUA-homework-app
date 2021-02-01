package com.egaragul.androidfundametals.ui.movies.list

import androidx.recyclerview.widget.DiffUtil
import com.egaragul.androidfundametals.ui.movies.data.Movie

/**
 * Created by Eugene Garagulya
 * Date: 07.12.2020
 */
class MovieDiffUtilCallback(
        private val oldList: List<Movie>,
        private val newList: List<Movie>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }


}